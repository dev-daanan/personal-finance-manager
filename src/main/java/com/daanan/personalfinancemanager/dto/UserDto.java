package com.daanan.personalfinancemanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotNull(message = "is required")
    @Size(min = 1, max = 50, message = "username of 1 to 50 characters required")
    private String username;

    @NotNull(message = "is required")
    @Email(message = "must be a valid email")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 1, max = 50, message = "password of 1 to 50 characters required")
    private String password;

    @NotNull(message = "is required")
    private String name;

    // GETTERS AND SETTERS

    public String getUsername( ) {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getEmail( ) {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword( ) {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getName( ) {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}

