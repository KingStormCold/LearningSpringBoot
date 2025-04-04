package com.store_phone.dtos;

import com.store_phone.entities.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class SpecificationsDTO extends BaseDTO {
    private String specificationsId;
    private String specificationsContent;
    private ProductDTO productEntity;

    public String getSpecificationsId() {
        return specificationsId;
    }

    public void setSpecificationsId(String specificationsId) {
        this.specificationsId = specificationsId;
    }

    public String getSpecificationsContent() {
        return specificationsContent;
    }

    public void setSpecificationsContent(String specificationsContent) {
        this.specificationsContent = specificationsContent;
    }

    public ProductDTO getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductDTO productEntity) {
        this.productEntity = productEntity;
    }
}
