package com.store_phone.dto;

import java.util.Set;

public class ProductInfoDTO extends BaseDTO {

	private String productInfoId;

    private ProductDTO product;

    private String productInfoName;

    private PromotionDTO promotion;
    
    private Set<ProductInfoDetailDTO> productInfoDetail;

	public String getProductInfoId() {
		return productInfoId;
	}

	public void setProductInfoId(String productInfoId) {
		this.productInfoId = productInfoId;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public String getProductInfoName() {
		return productInfoName;
	}

	public void setProductInfoName(String productInfoName) {
		this.productInfoName = productInfoName;
	}

	public PromotionDTO getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionDTO promotion) {
		this.promotion = promotion;
	}

	public Set<ProductInfoDetailDTO> getProductInfoDetail() {
		return productInfoDetail;
	}

	public void setProductInfoDetail(Set<ProductInfoDetailDTO> productInfoDetail) {
		this.productInfoDetail = productInfoDetail;
	}
    
}
