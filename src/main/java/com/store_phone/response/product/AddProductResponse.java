package com.store_phone.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.ProductDTO;

public class AddProductResponse {
	
	@JsonProperty("product_id")
    private String productId;

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
    
    @JsonProperty("category_id")
    private String categoryId;
    
    @JsonProperty("category_name")
    private String categoryName;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    
	public AddProductResponse(ProductDTO dto) {
		this.productId = dto.getProductId();
		this.productName = dto.getProductName();
		this.sortDescription = dto.getSortDescription();
		this.content = dto.getContent();
		this.image = dto.getImage();
		this.infoInsurance = dto.getInfoInsurance();
		this.categoryId = dto.getCategory().getCategoryId();
		this.categoryName = dto.getCategory().getCategoryName();
	}
}
