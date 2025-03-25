package com.store_phone.entity;

import java.util.Set;

import jakarta.persistence.*;

@Table(name = "productInfo")
@Entity
public class ProductInfoEntity extends BaseEntity{
	
	@Id
    @Column(name = "product_info_id")
    private String productInfoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "product_info_name")
    private String productInfoName;

    @OneToOne(mappedBy = "productInfo", cascade = CascadeType.REMOVE)
    private PromotionEntity promotion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productInfo", cascade = CascadeType.REMOVE)
    private Set<ProductInfoDetailEntity> productInfoDetail;

	public String getProductInfoId() {
		return productInfoId;
	}

	public void setProductInfoId(String productInfoId) {
		this.productInfoId = productInfoId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getProductInfoName() {
		return productInfoName;
	}

	public void setProductInfoName(String productInfoName) {
		this.productInfoName = productInfoName;
	}

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	public Set<ProductInfoDetailEntity> getProductInfoDetail() {
		return productInfoDetail;
	}

	public void setProductInfoDetail(Set<ProductInfoDetailEntity> productInfoDetail) {
		this.productInfoDetail = productInfoDetail;
	}

}
