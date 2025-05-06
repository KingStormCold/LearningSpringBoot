package com.store_phone.response.preferential;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.PreferentialDTO;
import com.store_phone.utils.DateUtils;

public class PreferenceInfo {
	@JsonProperty("preferential_id")
	private String preferentialId;

	@JsonProperty("content")
	private String content;

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

	public PreferenceInfo(PreferentialDTO dto) {
		this.preferentialId = dto.getPreferentialId();
		this.content = dto.getContent();
		this.productId = dto.getProduct().getProductId();
		this.createdBy = dto.getCreatedBy();
		this.createdDate = dto.getCreatedDate();
		this.updatedBy = dto.getUpdatedBy();
		this.updatedDate = dto.getUpdatedDate();
	}
}
