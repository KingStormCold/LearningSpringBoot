package com.store_phone.entity;

import jakarta.persistence.*;

@Table(name = "preferential")
@Entity
public class PreferentialEntity extends BaseEntity {
	
	@Id
    @Column(name = "preferential_id")
    private String preferentialId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}
