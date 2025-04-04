package com.store_phone.dtos;

import com.store_phone.entities.ProductInfoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class PromotionDTO extends BaseDTO {
    private String promotionId;
    private String Content;
    private ProductInfoDTO productInfoEntity;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public ProductInfoDTO getProductInfoEntity() {
        return productInfoEntity;
    }

    public void setProductInfoEntity(ProductInfoDTO productInfoEntity) {
        this.productInfoEntity = productInfoEntity;
    }
}
