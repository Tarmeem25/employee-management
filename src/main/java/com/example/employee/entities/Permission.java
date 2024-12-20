package com.example.employee.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permission_id;
    private String permission_name;

    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles;

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Permission() {
    }

    public Permission(String permission_name) {
        this.permission_name = permission_name;
    }
}
