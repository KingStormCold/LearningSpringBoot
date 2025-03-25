package com.store_phone.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{
	
	@Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "sort_description", columnDefinition = "TEXT")
    private String sortDescription;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "info_insurance", columnDefinition = "TEXT")
    private String infoInsurance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", nullable = false)
    private UserEntity user;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    private SpecificationEntity specifications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<ProductInfoEntity> productInfo;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    private PreferentialEntity preferential;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSortDescription() {
		return sortDescription;
	}

	public void setSortDescription(String sortDescription) {
		this.sortDescription = sortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfoInsurance() {
		return infoInsurance;
	}

	public void setInfoInsurance(String infoInsurance) {
		this.infoInsurance = infoInsurance;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public SpecificationEntity getSpecifications() {
		return specifications;
	}

	public void setSpecifications(SpecificationEntity specifications) {
		this.specifications = specifications;
	}

	public Set<ProductInfoEntity> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Set<ProductInfoEntity> productInfo) {
		this.productInfo = productInfo;
	}

	public PreferentialEntity getPreferential() {
		return preferential;
	}

	public void setPreferential(PreferentialEntity preferential) {
		this.preferential = preferential;
	}

}
