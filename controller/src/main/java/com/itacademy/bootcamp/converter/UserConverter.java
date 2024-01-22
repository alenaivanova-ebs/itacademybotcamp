package com.itacademy.bootcamp.converter;
import com.itacademy.bootcamp.dto.UserDTO;
import com.itacademy.bootcamp.model.Role;
import com.itacademy.bootcamp.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserConverter {

    private UserConverter() {
    }

    public static UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setUserName(user.getUsername());
        userDTO.setUserMiddleName(user.getMiddlename());
        userDTO.setUserSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole().toString());
        return userDTO;
    }

    public static User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUserName());
        user.setMiddlename(userDTO.getUserMiddleName());
        user.setSurname(userDTO.getUserSurname());
        user.setRole(Role.valueOf(userDTO.getRole()));
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public static Map<String, Object> convertUserToMap(User user, String includedFields) {
        UserDTO userDTO = convertToDto(user);
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userDTO.getUserId());
        if (includedFields != null) {
            String[] filterCriteria = includedFields.split(",");
            List<String> keysForFiltering = Arrays.asList(filterCriteria);
            return result
                    .entrySet()
                    .stream()
                    .filter(e -> keysForFiltering.contains(e.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        } else {
            return result;
        }
    }
}


