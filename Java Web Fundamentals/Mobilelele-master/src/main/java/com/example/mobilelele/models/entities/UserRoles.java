package com.example.mobilelele.models.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "user_roles")
public class UserRoles {
    private Long id;
    private Roles role;
    private List<User> users;

    public UserRoles() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "role")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
