package com.itacademy.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itacademy.bootcamp.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
@Data
@Setter
@Getter
public class UserDTO extends RepresentationModel<UserDTO> {
    private Long userId;
    private String userName;
    private String userMiddleName;
    private String userSurname;
    private String email;
    private String role;

    public UserDTO() {
    }

    @JsonCreator
    public UserDTO( @JsonProperty("id") String userId,
                    @JsonProperty("userName") String userName,
                    @JsonProperty("userMiddleName") String userMiddleName,
                    @JsonProperty("userSurname") String userSurname,
                    @JsonProperty("email") String email,
                    @JsonProperty("role") String role) {
        this.userName = userName;
        this.userMiddleName = userMiddleName;
        this.userSurname = userSurname;
        this.email = email;
        this.role = role;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        if (!super.equals(o)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userId, userDTO.userId) && Objects.equals(userName, userDTO.userName) && Objects.equals(userMiddleName, userDTO.userMiddleName) && Objects.equals(userSurname, userDTO.userSurname) && Objects.equals(email, userDTO.email) && Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, userName, userMiddleName, userSurname, email, role);
    }
}
