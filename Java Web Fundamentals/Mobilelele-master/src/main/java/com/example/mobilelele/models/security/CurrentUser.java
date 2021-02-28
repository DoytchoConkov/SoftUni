package com.example.mobilelele.models.security;

import com.example.mobilelele.models.entities.Roles;
import com.example.mobilelele.models.entities.UserRoles;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String username = ANONYMOUS;
    private boolean isAnonymous = true;
    private List<Roles> roles = new ArrayList<>();

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.username = ANONYMOUS;
            this.roles.clear();
        }
        isAnonymous = anonymous;

    }

    public boolean isAdmin() {
        boolean isa = this.roles.contains(Roles.Admin);
        return isa;
    }

    public void setRoles(List<Roles> role) {
        this.roles.clear();
        this.roles = role;
    }
}
