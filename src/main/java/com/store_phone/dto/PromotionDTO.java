package com.store_phone.dto;

public class PromotionDTO extends BaseDTO{
	private String promotionId;

    private ProductInfoDTO productInfo;

    private String content;

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public ProductInfoDTO getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfoDTO productInfo) {
		this.productInfo = productInfo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
