package com.example.mobilelele.models.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginViewModel {
    @NotNull
    @Size(min=2, max=20)
    private String username;
    @NotNull
    @Size(min=2, max=20)
    private String password;

    public UserLoginViewModel() {
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
}
