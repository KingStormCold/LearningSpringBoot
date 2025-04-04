package com.store_phone.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "specifications")
public class SpecificationEntity extends BaseEntity {

    @Id
    @Column(name = "specifications_id")
    private String specificationsId;

    @Column(name = "specifications_content", columnDefinition = "TEXT")
    private String specificationsContent;

    @OneToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

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
}
