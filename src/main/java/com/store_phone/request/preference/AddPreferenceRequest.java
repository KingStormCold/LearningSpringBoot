package com.store_phone.request.preference;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class AddPreferenceRequest extends BaseRequest {

    @JsonProperty("content")
    @NotBlank(message = "Content cannot empty")
    private String content;

    @JsonProperty("product_id")
    @NotBlank(message = "ProductId cannot be empty")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
