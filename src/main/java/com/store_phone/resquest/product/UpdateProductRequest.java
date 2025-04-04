package com.store_phone.resquest.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.resquest.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class UpdateProductRequest extends BaseRequest {
    @JsonProperty("product_id")
    @NotBlank(message = "ProductId cannot empty")
    private String productId;
    @JsonProperty("product_name")
    @NotBlank(message = "ProductName cannot empty")
    private String productName;
    @JsonProperty("short_description")
    @NotBlank(message = "shortDescription cannot empty")
    private String shortDescription;
    @JsonProperty("content")
    @NotBlank(message = "Content cannot empty")
    private String content;
    @JsonProperty("image")
    @NotBlank(message = "Image cannot empty")
    private String image;
    @JsonProperty("info_box")
    @NotBlank(message = "infoBox cannot empty")
    private String infoBox;
    @JsonProperty("info_insurance")
    @NotBlank(message = "infoInsurance cannot empty")
    private String infoInsurance;

    @JsonProperty("category_id")
    @NotBlank(message = "categoryId cannot be empty")
    private String categoryId;

    @JsonProperty("user_name")
    @NotBlank(message = "userName cannot be empty")
    private String userName;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfoBox() {
        return infoBox;
    }

    public void setInfoBox(String infoBox) {
        this.infoBox = infoBox;
    }

    public String getInfoInsurance() {
        return infoInsurance;
    }

    public void setInfoInsurance(String infoInsurance) {
        this.infoInsurance = infoInsurance;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
