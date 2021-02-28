package com.example.mobilelele.models.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterViewModel {
    @NotNull
    @Size(min=2, max=20)
    private String username;
    @NotNull
    @Size(min=4, max=20)
    private String password;
    @NotNull
    @Size(min=2, max=20)
    private String firstName;
    @NotNull
    @Size(min=2, max=20)
    private String lastName;

    public UserRegisterViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
