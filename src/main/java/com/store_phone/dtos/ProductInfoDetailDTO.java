package com.store_phone.dtos;

import jakarta.persistence.Column;

public class ProductInfoDetailDTO {
    private String productInfoDetailId;
    private String name;
    private String images;
    private double total;
    private double buyNowPrice;
    private double installmentPrice;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public double getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(double installmentPrice) {
        this.installmentPrice = installmentPrice;
    }
}
