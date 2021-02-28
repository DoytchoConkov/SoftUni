package com.example.mobilelele.models.view;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRoleSetServiceModel {
    @NotNull
    @Size(min = 1)
    private String username;
    private String admin;
    private String user;

    public UserRoleSetServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
