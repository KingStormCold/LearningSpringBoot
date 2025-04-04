package com.store_phone.response.category;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.response.BaseInfo;

public class CategoryInfo extends BaseInfo {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryRoot;

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

    public CategoryInfo(CategoryDTO dto) {
        this.categoryId = dto.getCategoryId();
        this.categoryName = dto.getCategoryName();
        this.categoryDescription = dto.getCategoryDescription();
        this.categoryRoot = dto.getCategoryRoot();
        this.createdDate = dto.getCreatedDate();
        this.createdBy = dto.getCreatedBy();
        this.updatedDate = dto.getUpdatedDate();
        this.updatedBy = dto.getUpdatedBy();
    }
}
