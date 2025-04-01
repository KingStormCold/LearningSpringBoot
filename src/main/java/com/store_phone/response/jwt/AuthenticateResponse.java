package com.store_phone.response.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticateResponse {

	@JsonProperty("token")
    private String token;

    public AuthenticateResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
