package com.store_phone.request.promotion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class AddPromotionRequest extends BaseRequest {
    @JsonProperty("content")
    private String content;

    @JsonProperty("product_info_id")
    @NotBlank(message = "Product Info Id cannot be empty")
    private String productInfoId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }
}
