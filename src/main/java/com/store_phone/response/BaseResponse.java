package com.store_phone.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
