package com.store_phone.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.CategoryDTO;

public class AddCategoryResponse {
	
	@JsonProperty("category_id")
	private String categoryId;

	@JsonProperty("category_name")
    private String categoryName;

	@JsonProperty("category_description")
    private String categoryDescription;

	@JsonProperty("category_root")
    private String categoryRoot;
    
	@JsonProperty("display_in_slider")
    private Boolean displayInSlider;
	
	@JsonProperty("created_by")
	private String createdBy;

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
	
	public AddCategoryResponse(CategoryDTO dto) {
		this.categoryId = dto.getCategoryId();
		this.categoryDescription = dto.getCategoryDescription();
		this.categoryName = dto.getCategoryName();
		this.displayInSlider = dto.getDisplayInSlider();
		this.categoryRoot = dto.getCategoryRoot();
		this.createdBy = dto.getCreatedBy();
	}
	
}
