package com.store_phone.response.category;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.utils.DateUtils;

public class CategoryDetail {

	@JsonProperty("category_id")
	private String categoryId;
	
	@JsonProperty("category_name")
	private String categoryName;
	
	@JsonProperty("category_description")
	private String categoryDescription;
	
	@JsonProperty("category_root")
	private String categoryRoot;
	
	@JsonProperty("category_root_name")
	private String categoryRootName;
	
	@JsonProperty("display_in_slider")
	private Boolean displayInSlider;
	
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

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryRoot() {
		return categoryRoot;
	}

	public void setCategoryRoot(String categoryRoot) {
		this.categoryRoot = categoryRoot;
	}

	public Boolean getDisplayInSlider() {
		return displayInSlider;
	}

	public void setDisplayInSlider(Boolean displayInSlider) {
		this.displayInSlider = displayInSlider;
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
	
	public String getCategoryRootName() {
		return categoryRootName;
	}

	public void setCategoryRootName(String categoryRootName) {
		this.categoryRootName = categoryRootName;
	}

	public CategoryDetail(CategoryDTO dto, String categoryRootName) {
		this.categoryId = dto.getCategoryId();
		this.categoryDescription = dto.getCategoryDescription();
		this.categoryName = dto.getCategoryName();
		this.categoryRoot = dto.getCategoryRoot();
		this.createdBy = dto.getCreatedBy();
		this.createdDate = dto.getCreatedDate();
		this.displayInSlider = dto.getDisplayInSlider();
		this.updatedBy = dto.getUpdatedBy();
		this.updatedDate = dto.getUpdatedDate();
		this.categoryRootName = categoryRootName;
	}
	
	public CategoryDetail(CategoryDTO dto, CategoryDTO categoryRoot) {
		this.categoryId = dto.getCategoryId();
		this.categoryDescription = dto.getCategoryDescription();
		this.categoryName = dto.getCategoryName();
		this.categoryRoot = dto.getCategoryRoot();
		this.createdBy = dto.getCreatedBy();
		this.createdDate = dto.getCreatedDate();
		this.displayInSlider = dto.getDisplayInSlider();
		this.updatedBy = dto.getUpdatedBy();
		this.updatedDate = dto.getUpdatedDate();
		this.categoryRootName = categoryRoot == null ? "" : categoryRoot.getCategoryName();
	}
	
}
