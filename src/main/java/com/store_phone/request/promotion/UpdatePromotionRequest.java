package com.store_phone.request.promotion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class UpdatePromotionRequest extends BaseRequest {
    @JsonProperty("promotion_id")
    @NotBlank(message = "Promotion ID cannot be empty")
    private String promotionId;

    @JsonProperty("product_info_id")
    @NotBlank(message = "Product Info Id cannot be empty")
    private String productInfoId;

    @JsonProperty("content")
    @NotBlank(message = "Content cannot be empty")
    private String content;

}
