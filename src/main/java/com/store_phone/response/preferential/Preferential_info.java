package com.store_phone.response.preferential;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.response.BaseInfo;

public class Preferential_info extends BaseInfo {
    private String preferentialId;
    private String content;
    private String productId;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(String preferentialId) {
        this.preferentialId = preferentialId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Preferential_info(PreferentialDTO dto) {
        this.preferentialId = dto.getPreferentialId();
        this.content = dto.getContent();
        this.productId = dto.getProductDTO().getProductId();
        this.productName = dto.getProductDTO().getProductName();
        this.createdBy = dto.getCreatedBy();
        this.createdDate = dto.getCreatedDate();
        this.updatedBy = dto.getUpdatedBy();
        this.updatedDate = dto.getUpdatedDate();
    }
}
