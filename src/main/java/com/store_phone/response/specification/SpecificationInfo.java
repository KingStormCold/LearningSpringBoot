package com.store_phone.response.specification;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.utils.DateUtils;

public class SpecificationInfo {
	
	@JsonProperty("specification_id")
	private String specificationId;

	@JsonProperty("specifications_content")
	private String specifications_content;

	@JsonProperty("product_id")
	private String productId;

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

	public String getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}

	public String getSpecificationsContent() {
		return specifications_content;
	}

	public void getSpecificationsContent(String specifications_content) {
		this.specifications_content = specifications_content;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public SpecificationInfo(SpecificationDTO dto) {
		
		this.specificationId =dto.getSpecificationsId();
		this.specifications_content = dto.getSpecificationsContent();
		this.productId = dto.getProduct().getProductId();
		this.createdBy = dto.getCreatedBy();
		this.createdDate = dto.getCreatedDate();
		this.updatedBy = dto.getUpdatedBy();
		this.updatedDate = dto.getUpdatedDate();
	}

	
	
	
	
}
