package com.store_phone.resquest.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class UpdateRoleRequest {
    @JsonProperty("role_id")
    @NotBlank(message = "Cannot empty")
    private String roleId;

    @JsonProperty("role_name")
    @NotBlank(message = "Cannot empty")
    private String roleName;

    @JsonProperty("role_description")
    @NotBlank(message = "Cannot empty for description")
    private String roleDescription;

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
