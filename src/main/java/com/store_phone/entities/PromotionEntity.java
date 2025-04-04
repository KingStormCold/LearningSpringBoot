package com.store_phone.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "promotion")
public class PromotionEntity extends BaseEntity {

    @Id
    @Column(name = "promotion_id")
    private String promotionId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @OneToOne
    @JoinColumn(name = "product_info_id", nullable = false)
    private ProductInfoEntity productInfo;

    public ProductInfoEntity getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfoEntity productInfo) {
        this.productInfo = productInfo;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
