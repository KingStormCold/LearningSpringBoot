package com.store_phone.entity;

import jakarta.persistence.*;

@Table(name = "promotion")
@Entity
public class PromotionEntity extends BaseEntity {

	@Id
	@Column(name = "promotion_id")
	private String promotionId;

	@OneToOne
	@JoinColumn(name = "product_info_id", nullable = false)
	private ProductInfoEntity productInfo;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public ProductInfoEntity getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfoEntity productInfo) {
		this.productInfo = productInfo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
