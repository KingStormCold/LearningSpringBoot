package com.store_phone.dto;

public class CategoryDTO extends BaseDTO {

	private String categoryId;

	private String categoryName;

	private String categoryDescription;

	private String categoryRoot;

	private Boolean displayInSlider;

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
	
}
