package com.store_phone.request.specification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class UpdateSpecificationRequest extends BaseRequest {

    @JsonProperty("specifications_name")
    @NotBlank(message = "Specification cannot empty")
    private String specificationId;

    @JsonProperty("specifications_content")
    @NotBlank(message = "Specifications content cannot empty")
    private String specificationsContent;

    @JsonProperty("product_id")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecificationsContent() {
        return specificationsContent;
    }

    public void setSpecificationsContent(String specificationsContent) {
        this.specificationsContent = specificationsContent;
    }
}
