package com.store_phone.response.promotion;

import com.store_phone.dto.PromotionDTO;
import com.store_phone.response.BaseInfo;

public class PromotionResponse extends BaseInfo {
    private String promotionId;
    private String content;
    private String productInfoId;

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

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public PromotionResponse(PromotionDTO dto) {
        this.promotionId = dto.getPromotionId();
        this.content = dto.getContent();
        this.productInfoId = dto.getProductInfo().getProductInfoId();
    }
}
