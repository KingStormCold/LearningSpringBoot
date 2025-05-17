package com.store_phone.response.product_info_detail;

import com.store_phone.dto.ProductInfoDetailDTO;
import com.store_phone.request.BaseRequest;
import com.store_phone.response.BaseInfo;

public class ProductInfoDetailResponse extends BaseInfo {

    private String productInfoDetailId;
    private String productInfoId;
    private String productInfoName;
    private String name;
    private String images;
    private String total;
    private Long buyNowPrice;
    private Long installmentPrice;
    private Long discountPrice;
    private Long priceAfterDiscount;
    private Boolean bestseller;

    public ProductInfoDetailResponse(ProductInfoDetailDTO dto) {
        this.productInfoDetailId = dto.getProductInfoDetailId();
        this.name = dto.getName();
        this.images = dto.getImages();
        this.total = dto.getTotal();
        this.bestseller = dto.getBestseller();
        this.buyNowPrice = dto.getBuyNowPrice();
        this.discountPrice = dto.getDiscountPrice();
        this.installmentPrice = dto.getInstallmentPrice();
        this.priceAfterDiscount = dto.getDiscountPrice();
        this.productInfoId = dto.getProductInfo().getProductInfoId();
        this.productInfoName = dto.getProductInfo().getProductInfoName();
    }

    public String getProductInfoDetailId() {
        return productInfoDetailId;
    }

    public void setProductInfoDetailId(String productInfoDetailId) {
        this.productInfoDetailId = productInfoDetailId;
    }

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getProductInfoName() {
        return productInfoName;
    }

    public void setProductInfoName(String productInfoName) {
        this.productInfoName = productInfoName;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }
}
