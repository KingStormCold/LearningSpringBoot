package com.store_phone.request.role;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class UpdateRoleRequest {
	
	@NotBlank(message = "role_id không được rỗng")
	@JsonProperty("role_id")
	private String roleId;

	@NotBlank(message = "role_name không được rỗng")
	@JsonProperty("role_name")
	private String roleName;
	
	@NotBlank(message = "role_description không được rỗng")
	@JsonProperty("role_description")
	private String roleDesciption;

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

	public String getRoleDesciption() {
		return roleDesciption;
	}

	public void setRoleDesciption(String roleDesciption) {
		this.roleDesciption = roleDesciption;
	}

}
