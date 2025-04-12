package com.store_phone.request.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class AddProductRequest {

	@NotBlank(message = "product_name không được rỗng.")
    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("sort_description")
    private String sortDescription;

    @JsonProperty("content")
    private String content;

    @JsonProperty("image")
    private String image;

    @JsonProperty("info_insurance")
    private String infoInsurance;
    
    @NotBlank(message = "category_id không được rỗng.")
    @JsonProperty("category_id")
    private String categoryId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSortDescription() {
		return sortDescription;
	}

	public void setSortDescription(String sortDescription) {
		this.sortDescription = sortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfoInsurance() {
		return infoInsurance;
	}

	public void setInfoInsurance(String infoInsurance) {
		this.infoInsurance = infoInsurance;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
