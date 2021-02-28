package workshop.models.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import workshop.models.entities.RoleName;

import java.util.ArrayList;
import java.util.List;
@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String username = ANONYMOUS;
    private RoleName role;

    public CurrentUser() {
    }

    public static String getANONYMOUS() {
        return ANONYMOUS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
    public boolean isAdmin(){
        return true;
    }
}
