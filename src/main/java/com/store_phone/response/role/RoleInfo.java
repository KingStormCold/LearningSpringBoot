package com.store_phone.response.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.RoleDTO;

public class RoleInfo {

	@JsonProperty("role_id")
	private String roleId;

	@JsonProperty("role_name")
    private String roleName;

	@JsonProperty("role_description")
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
	
	public RoleInfo(RoleDTO dto) {
		this.roleId = dto.getRoleId();
		this.roleName= dto.getRoleName();
		this.roleDescription = dto.getRoleDescription();
	}
}
