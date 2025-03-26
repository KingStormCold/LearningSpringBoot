package com.store_phone.request.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank(message = "Username không được rỗng")
    @JsonProperty("user_name")
    private String userName;

    @NotBlank(message = "Password không được rỗng")
    @JsonProperty("password")
    private String password;

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
}
