package com.itacademy.bootcamp.controller;

import com.itacademy.bootcamp.converter.UserConverter;
import com.itacademy.bootcamp.dto.UserDTO;
import com.itacademy.bootcamp.exception.ServiceException;
import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.response.InfoResponse;
import com.itacademy.bootcamp.UserService;
import com.itacademy.bootcamp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    private MessageSource messageSource;

    @Autowired
    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public HttpEntity<List<UserDTO>> getUsers(Pageable pageable) throws ServiceException {
        List<UserDTO> usersDTO = userService.getUsers(pageable)
                .stream()
                .map(UserConverter::convertToDto)
                .collect(Collectors.toList());
        addUsersHATEOAS(usersDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @PostMapping
    public InfoResponse addUser(@RequestBody UserDTO userDTO, Locale locale) throws ServiceException {
        UserValidator.validateUserDTO(userDTO, locale);
        User user = UserConverter.convertToEntity(userDTO);
        Long userId = userService.create(user);
        String message = messageSource.getMessage("label.user.created", null, locale);
        return new InfoResponse(
                HttpStatus.CREATED.value(),
                message + ":" + userId,
                HttpStatus.CREATED.toString());
    }

    private void addUsersHATEOAS(List<UserDTO> usersDTO) throws ServiceException {
        for (UserDTO userDTO : usersDTO) {
            userDTO.add(linkTo(methodOn(UserController.class).getUserById(userDTO.getUserId(), null)).withSelfRel());
        }
    }

    @GetMapping("/{userId}")
    public Map<String, Object> getUserById(@PathVariable Long userId, @RequestParam(value = "include", required = false) String include) throws ServiceException {
        User user = userService.get(userId);
        return UserConverter.convertUserToMap(user, include);
    }
}
