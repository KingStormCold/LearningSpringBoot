package com.store_phone.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table( name = "product")
public class ProductEntity extends BaseEntity {

    @Id
    @Column( name = "product_id")
    private String productId;

    @Column( name = "product_name")
    private String productName;

    @Column( name = "short_description", columnDefinition = "TEXT")
    private String shortDescription;

    @Column( name = "content", columnDefinition = "TEXT")
    private String content;

    @Column( name = "image", columnDefinition = "TEXT")
    private String image;

    @Column( name = "info_box", columnDefinition = "TEXT")
    private String infoBox;

    @Column( name = "info_insurance", columnDefinition = "TEXT")
    private String infoInsurance;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_name", nullable = false)
   private UserEntity user;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "category_id", nullable = false)
   private CategoryEntity category;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
   private Set<ProductInfoEntity> productInfo;

   @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
   private SpecificationEntity specifications;

   @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
   private PreferentialEntity preferential;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<ProductInfoEntity> getProductInfoEntities() {
        return productInfo;
    }

    public void setProductInfoEntities(Set<ProductInfoEntity> productInfoEntities) {
        this.productInfo = productInfoEntities;
    }

    public PreferentialEntity getPreferential() {
        return preferential;
    }

    public void setPreferential(PreferentialEntity preferential) {
        this.preferential = preferential;
    }

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getInfoBox() {
        return infoBox;
    }

    public void setInfoBox(String infoBox) {
        this.infoBox = infoBox;
    }

    public String getInfoInsurance() {
        return infoInsurance;
    }

    public void setInfoInsurance(String infoInsurance) {
        this.infoInsurance = infoInsurance;
    }
}
