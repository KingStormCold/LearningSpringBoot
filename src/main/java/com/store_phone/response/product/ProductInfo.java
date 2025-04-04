package com.store_phone.response.product;

import com.store_phone.dtos.ProductDTO;
import com.store_phone.response.BaseInfo;

public class ProductInfo extends BaseInfo {
    private String productId;
    private String productName;
    private String shortDescription;
    private String content;
    private String image;
    private String infoBox;
    private String infoInsurance;

    public ProductInfo(ProductDTO dto) {
        this.productId = dto.getProductId();
        this.productName = dto.getProductName();
        this.shortDescription = dto.getShortDescription();
        this.content = dto.getContent();
        this.image = dto.getImage();
        this.infoBox = dto.getInfoBox();
        this.infoInsurance = dto.getInfoInsurance();
        this.createdBy = dto.getCreatedBy();
        this.createdDate = dto.getCreatedDate();
        this.updatedBy = dto.getUpdatedBy();
        this.updatedDate = dto.getUpdatedDate();
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
