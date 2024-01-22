package com.itacademy.bootcamp.validator;

import com.itacademy.bootcamp.dto.UserDTO;
import com.itacademy.bootcamp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.regex.Pattern;

@Component
public class UserValidator {

    private static final String regexPattern = "^(.+)@(\\S+)$";
    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static void validateUserDTO(UserDTO userDTO, Locale locale) {
        if (userDTO.getUserName() == null) {
            String errorMessage = messageSource.getMessage("label.not.entered.name", null, locale);
            throw new IllegalArgumentException(errorMessage);
        } else if (userDTO.getUserSurname() == null) {
            String errorMessage = messageSource.getMessage("label.not.entered.surname", null, locale);
            throw new IllegalArgumentException(errorMessage);
        } else if (userDTO.getUserMiddleName() == null) {
            String errorMessage = messageSource.getMessage("label.not.entered.middlename", null, locale);
            throw new IllegalArgumentException(errorMessage);
        } else if (userDTO.getEmail() == null) {
            String errorMessage = messageSource.getMessage("label.not.entered.email", null, locale);
            throw new IllegalArgumentException(errorMessage);
        } else if (!contains(userDTO.getRole())) {
            String errorMessage = messageSource.getMessage("label.incorrect.role", null, locale);
            throw new IllegalArgumentException(errorMessage);
        } else if (!patternMatches(userDTO.getEmail())) {
            String errorMessage = messageSource.getMessage("label.incorrect.email", null, locale);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean contains(String input) {
        for (Role c : Role.values()) {
            if (c.name().equals(input)) {
                return true;
            }
        }
        return false;
    }

    private static boolean patternMatches(String emailAddress) {
        return Pattern.compile(UserValidator.regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
