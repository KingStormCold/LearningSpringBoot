package com.store_phone.resquest.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class UpdateUserRequest {

    @JsonProperty("user_name")
    @NotBlank(message = "UserName cannot empty")
    private String userName;

    @JsonProperty("password")
    @NotBlank(message = "Password cannot empty")
    private String password;

    @JsonProperty("full_name")
    @NotBlank(message = "FullName cannot empty")
    private String fullName;

    @JsonProperty("email")
    @NotBlank(message = "Email cannot empty")
    private String email;

    @JsonProperty("phone")
    @NotBlank(message = "Phone cannot empty")
    private String phone;

    @JsonProperty("address")
    @NotBlank(message = "Address cannot empty")
    private String address;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("active")
    @NotNull(message = "Active cannot empty")
    private Boolean active;

    @JsonProperty("roles")
    private Set<String> roles;

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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
}
