package workshop.models.bindingModels;

import workshop.models.entities.RoleName;

public class UserRoleBindingModel {
    private String username;
    private RoleName role;

    public UserRoleBindingModel() {
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
}
