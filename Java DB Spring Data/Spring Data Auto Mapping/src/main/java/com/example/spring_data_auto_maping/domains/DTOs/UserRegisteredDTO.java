package com.example.spring_data_auto_maping.domains.DTOs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisteredDTO {
    private String email;
    private String password;
    private String fullName;

    public UserRegisteredDTO() {
    }

    public UserRegisteredDTO(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    @Pattern(regexp = ".+@.+\\..+", message = "Email is not valid!!!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "([A-Z]+[a-z]+[0-9]+)", message = "Password is not valid!!!")
    @Size(min = 6, message = "Password is too short")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Full name can't be null")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
