package com.store_phone.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "product_info")
public class ProductInfoEntity extends BaseEntity {

    @Id
    @Column(name = "product_info_id")
    private String productInfoId;

    @Column(name = "product_info_name")
    private String productInfoName;

    @Column(name = "price")
    private double price;

    @Column(name = "original_price")
    private double originalPrice;

    @Column(name = "total")
    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productInfo", cascade = CascadeType.REMOVE)
    private Set<ProductInfoDetailEntity> productInfoDetail;

    @OneToOne(mappedBy = "productInfo", cascade = CascadeType.REMOVE)
    private PromotionEntity promotion;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
