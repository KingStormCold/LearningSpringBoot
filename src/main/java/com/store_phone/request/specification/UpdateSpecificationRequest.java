package com.store_phone.request.specification;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class UpdateSpecificationRequest {

	@NotBlank(message = "Id không được rỗng.")
	@JsonProperty("specification_id")
	private String specificationId;

	@NotBlank(message = "content không được rỗng.")
	@JsonProperty("content")
    private String content;
	
	@NotBlank(message = "ProductId không được rỗng.")
	@JsonProperty("product_id")
    private String product_id;

	public String getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
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
}
