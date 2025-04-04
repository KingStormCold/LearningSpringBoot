package com.store_phone.dtos;

import com.store_phone.response.user.UserInfo;
import jakarta.persistence.Column;

import java.util.List;
import java.util.Set;

public class ProductDTO extends BaseDTO {
    private String productId;
    private String productName;
    private String shortDescription;
    private String content;
    private String image;
    private String infoBox;
    private String infoInsurance;

    private CategoryDTO category;
    private UserDTO users;

    public UserDTO getUsers() {
        return users;
    }
    public void setUsers(UserDTO users) {
        this.users = users;
    }

    private List<ProductInfoDTO> productInfos;
    private SpecificationsDTO specifications;
    private PreferentialDTO preferential;

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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }


    public List<ProductInfoDTO> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfoDTO> productInfos) {
        this.productInfos = productInfos;
    }

    public SpecificationsDTO getSpecifications() {
        return specifications;
    }

    public void setSpecifications(SpecificationsDTO specifications) {
        this.specifications = specifications;
    }

    public PreferentialDTO getPreferential() {
        return preferential;
    }

    public void setPreferential(PreferentialDTO preferential) {
        this.preferential = preferential;
    }
}
