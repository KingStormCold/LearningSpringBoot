package com.store_phone.response.category;

import com.store_phone.dto.CategoryDTO;
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

    public CategoryInfo(CategoryDTO categoryDTO) {
        this.categoryId = categoryDTO.getCategoryId();
        this.categoryName = categoryDTO.getCategoryName();
        this.categoryDescription = categoryDTO.getCategoryDescription();
        this.categoryRoot = categoryDTO.getCategoryRoot();
        this.createdDate = categoryDTO.getCreatedDate();
        this.createdBy = categoryDTO.getCreatedBy();
        this.updatedDate = categoryDTO.getUpdatedDate();
        this.updatedBy = categoryDTO.getUpdatedBy();
    }
}
