package com.store_phone.request.product_info_detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;

public class UpdateProductInfoDetail extends BaseRequest {

    @JsonProperty("product_info_detail_id")
    @NotBlank(message = "product_info_detail_id cannot empty")
    private String productInfoDetailId;

    @JsonProperty("name")
    @NotBlank(message = "Name cannot empty")
    private String name;

    @JsonProperty("images")
    private String images;

    @JsonProperty("buy_now_price")
    private Long buyNowPrice;

    @JsonProperty("installment_price")
    private Long installmentPrice;

    @JsonProperty("discount_price")
    private Long discountPrice;

    @JsonProperty("price_after_discount")
    private Long priceAfterDiscount;

    @JsonProperty("total")
    private String total;

    @JsonProperty("product_info_id")
    private String productInfoId;

    @JsonProperty("best_seller")
    private Boolean bestSeller;

    public String getProductInfoDetailId() {
        return productInfoDetailId;
    }

    public void setProductInfoDetailId(String productInfoDetailId) {
        this.productInfoDetailId = productInfoDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Long getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Long buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Long getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(Long installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(Long priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public Boolean getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Boolean bestSeller) {
        this.bestSeller = bestSeller;
    }
}
