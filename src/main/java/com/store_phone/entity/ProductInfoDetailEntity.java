package com.store_phone.entity;

import jakarta.persistence.*;

@Table(name = "productInfoDetail")
@Entity
public class ProductInfoDetailEntity extends BaseEntity{
	
	@Id
    @Column(name = "product_info_detail_id")
    private String productInfoDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_info_id", nullable = false)
    private ProductInfoEntity productInfo;

    @Column(name = "name")
    private String name;

    @Column(name = "images", columnDefinition = "TEXT")
    private String images;

    @Column(name = "total")
    private String total;

    @Column(name = "buy_now_price")
    private Long buyNowPrice;

    @Column(name = "installment_price")
    private Long installmentPrice;
    
    @Column(name = "discount_price")
    private Long discountPrice;
    
    @Column(name = "price_after_discount")
    private Long priceAfterDiscount;
    
    @Column(name = "bestseller")
    private Boolean bestseller;

	public String getProductInfoDetailId() {
		return productInfoDetailId;
	}

	public void setProductInfoDetailId(String productInfoDetailId) {
		this.productInfoDetailId = productInfoDetailId;
	}

	public ProductInfoEntity getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfoEntity productInfo) {
		this.productInfo = productInfo;
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
