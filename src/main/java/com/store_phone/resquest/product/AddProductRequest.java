package com.store_phone.resquest.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.resquest.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class AddProductRequest extends BaseRequest {

    @JsonProperty("product_name")
    @NotBlank(message = "productName cannot empty")
    private String productName;

    @JsonProperty("short_description")
    @NotBlank(message = "shortDescription cannot empty")
    private String shortDescription;

    @JsonProperty("content")
    @NotBlank(message = "content cannot empty")
    private String content;

    @JsonProperty("image")
    @NotBlank(message = "image cannot empty")
    private String image;

    @JsonProperty("infoBox")
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
