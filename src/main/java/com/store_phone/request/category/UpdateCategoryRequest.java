package com.store_phone.request.category;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class UpdateCategoryRequest {

	@NotBlank(message = "category_name không được rỗng.")
	@JsonProperty("category_name")
    private String categoryName;

	@NotBlank(message = "category_description không được rỗng.")
	@JsonProperty("category_description")
    private String categoryDescription;

	@JsonProperty("category_root")
    private String categoryRoot;
    
	@JsonProperty("display_in_slider")
    private Boolean displayInSlider;

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
	
	
}
