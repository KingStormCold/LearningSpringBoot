package com.store_phone.request.preferential;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class UpdatePreferentialRequest extends BaseRequest {
    @JsonProperty("preferential_id")
    @NotBlank(message = "Preferential Id cannot empty")
    private String preferentialId;

    @JsonProperty("content")
    @NotBlank(message = "Content cannot empty")
    private String content;

    @JsonProperty("product_id")
    private String productId;

    public String getPreferentialId() {
        return preferentialId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
