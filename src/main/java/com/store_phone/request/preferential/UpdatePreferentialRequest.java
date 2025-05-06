package com.store_phone.request.preferential;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.utils.DateUtils;

import jakarta.validation.constraints.NotBlank;

public class UpdatePreferentialRequest {
	
	@NotBlank(message = "Id không được rỗng.")
	@JsonProperty("preferential_id")
	private String preferentialId;
	
	@NotBlank(message = "content không được rỗng.")
	@JsonProperty("content")
    private String content;
	
	@NotBlank(message = "ProductId không được rỗng.")
	@JsonProperty("product_id")
    private String product_id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = DateUtils.MY_TIME_ZONE)
   	@JsonProperty("updated_date")
   	private LocalDateTime updatedDate;
	
	

	public String getPreferentialId() {
		return preferentialId;
	}

	public void setPreferentialId(String preferentialId) {
		this.preferentialId = preferentialId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
