package com.store_phone.request.user;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class AddUserRequest {

	@JsonProperty("user_name")
	@NotBlank(message = "user_name không được rỗng.")
	private String userName;
	
	@JsonProperty("password")
	@NotBlank(message = "password không được rỗng.")
	private String password;
	
	@JsonProperty("full_name")
	@NotBlank(message = "full_name không được rỗng.")
	private String fullName;
	
	@JsonProperty("email")
	@NotBlank(message = "email không được rỗng.")
	private String email;
	
	@JsonProperty("phone")
	@NotBlank(message = "phone không được rỗng.")
	private String phone;
	
	@JsonProperty("address")
	@NotBlank(message = "address không được rỗng.")
	private String address;
	
	@JsonProperty("roles")
	private Set<String> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
