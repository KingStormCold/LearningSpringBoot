package com.store_phone.resquest.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.resquest.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class AddCategoryRequest extends BaseRequest {
    @JsonProperty("category_name")
    @NotBlank(message = "categoryName cannot empty")
    private String categoryName;

    @JsonProperty("category_description")
    @NotBlank(message = "categoryDescription cannot empty")
    private String categoryDescription;

    @JsonProperty("category_root")
    @NotBlank(message = "categoryRoot cannot empty")
    private String categoryRoot;

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
}
