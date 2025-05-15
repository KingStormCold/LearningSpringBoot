package com.store_phone.request.product_info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class AddProductInfoRequest extends BaseRequest {
    @JsonProperty("product_info_name")
    @NotBlank(message = "product_info_name")
    private String productInfoName;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("price")
    @NotBlank(message = "price")
    private Double price;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("original_price")
    private Double original_price;

    public String getProductInfoName() {
        return productInfoName;
    }

    public void setProductInfoName(String productInfoName) {
        this.productInfoName = productInfoName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }
}
