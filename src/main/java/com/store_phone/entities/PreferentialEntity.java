package com.store_phone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preferential")
public class PreferentialEntity {

    @Id
    @Column(name = "preferential_id")
    private String preferentialId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
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
}
