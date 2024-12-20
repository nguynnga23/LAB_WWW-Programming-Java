package com.example.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.entities.User}
 */
@Value
public class UserLoginDTO implements Serializable {
    private String username;
    private String password;

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}