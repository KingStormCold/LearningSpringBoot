package com.store_phone.resquest.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class AddRoleRequest {
    @JsonProperty("role_name")
    @NotBlank(message = "Cannot empty for this field")
    private String roleName;

    @JsonProperty("role_description")
    @NotBlank(message = "Cannot empty description")
    private String roleDescription;

    @JsonProperty("users")
    private Set<String> users;

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
