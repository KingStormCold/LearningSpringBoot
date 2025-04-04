package com.store_phone.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table ( name = "category")
public class CategoryEntity extends BaseEntity {

    @Id
    @Column( name = "category_id")
    private String categoryId;

    @Column( name = "category_name")
    private String categoryName;

    @Column( name = "category_description")
    private String categoryDescription;

    @Column( name = "category_root")
    private String categoryRoot;

    public Set<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(Set<ProductEntity> product) {
        this.product = product;
    }

    @Column( name = "display_in_slider")
    private Boolean displayInSlider;

    public Boolean getDisplayInSlider() {
        return displayInSlider;
    }

    public void setDisplayInSlider(Boolean displayInSlider) {
        this.displayInSlider = displayInSlider;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    private Set<ProductEntity> product;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryRoot() {
        return categoryRoot;
    }

    public void setCategoryRoot(String categoryRoot) {
        this.categoryRoot = categoryRoot;
    }
}

