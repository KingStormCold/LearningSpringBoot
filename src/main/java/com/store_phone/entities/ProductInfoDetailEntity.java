package com.store_phone.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;

@Entity
@Table(name = "product_info_detail")
public class ProductInfoDetailEntity extends BaseEntity {

    @Id
    @Column(name = "product_info_detail_id")
    private String productInfoDetailId;

    @Column(name = "name")
    private String name;

    @Column(name = "images")
    private String images;

    @Column(name = "total")
    private double total;

    @Column(name = "buy_now_price")
    private double buyNowPrice;

    @Column(name = "installment_price")
    private double installmentPrice;

    @Column(name = "discount_price")
    private Long discountPrice;

    @Column(name = "price_after_discount")
    private Long priceAfterDiscount;

    @Column(name = "bestseller")
    private Boolean bestseller;

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

    public ProductInfoEntity getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfoEntity productInfo) {
        this.productInfo = productInfo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_info_id", nullable = false)
    private ProductInfoEntity productInfo;

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
