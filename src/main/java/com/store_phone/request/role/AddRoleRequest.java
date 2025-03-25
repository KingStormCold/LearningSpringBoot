package com.store_phone.request.role;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class AddRoleRequest {

	@NotBlank(message = "role_name không được rỗng")
	@JsonProperty("role_name")
	private String roleName;
	
	@NotBlank(message = "role_description không được rỗng")
	@JsonProperty("role_description")
	private String roleDesciption;

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
