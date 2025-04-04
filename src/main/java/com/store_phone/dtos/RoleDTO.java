package com.store_phone.dtos;

import com.store_phone.entities.RoleEntity;
import com.store_phone.entities.UserEntity;

import java.util.Set;

public class RoleDTO {
    private String roleId;
    private String roleName;
    private String roleDescription;
    private Set<UserDTO> users;

    public Set<UserDTO> getUsers() {
        return users;
    }
    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
