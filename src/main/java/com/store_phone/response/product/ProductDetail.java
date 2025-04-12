package com.store_phone.response.product;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.ProductDTO;
import com.store_phone.utils.DateUtils;

public class ProductDetail {

	@JsonProperty("product_id")
    private String productId;

	@JsonProperty("product_name")
    private String productName;
    
    @JsonProperty("category_id")
    private String categoryId;
    
    @JsonProperty("category_name")
    private String categoryName;
    
    @JsonProperty("created_by")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = DateUtils.MY_TIME_ZONE)
	@JsonProperty("created_date")
	private LocalDateTime createdDate;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = DateUtils.MY_TIME_ZONE)
	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public ProductDetail(ProductDTO dto) {
		this.categoryId = dto.getCategory().getCategoryId();
		this.categoryName = dto.getCategory().getCategoryName();
		this.productId = dto.getProductId();
		this.createdBy = dto.getCreatedBy();
		this.createdDate = dto.getCreatedDate();
		this.productName = dto.getProductName();
		this.updatedBy = dto.getUpdatedBy();
		this.updatedDate = dto.getUpdatedDate();
	}
}
