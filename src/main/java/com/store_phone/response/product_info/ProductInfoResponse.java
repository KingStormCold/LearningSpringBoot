package com.store_phone.response.product_info;

import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.dto.ProductInfoDetailDTO;
import com.store_phone.dto.PromotionDTO;
import com.store_phone.response.BaseInfo;

import java.util.Set;


public class ProductInfoResponse extends BaseInfo {

    private String productInfoId;
    private String productInfoName;
    private Double price;
    private Double total;
    private Double originalPrice;
    private String productId;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    private String productName;
    private String promotionId;
    private Set<ProductInfoDetailDTO> productInfoDetail;

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getProductInfoName() {
        return productInfoName;
    }

    public void setProductInfoName(String productInfoName) {
        this.productInfoName = productInfoName;
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

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Set<ProductInfoDetailDTO> getProductInfoDetail() {
        return productInfoDetail;
    }

    public void setProductInfoDetail(Set<ProductInfoDetailDTO> productInfoDetail) {
        this.productInfoDetail = productInfoDetail;
    }

    public ProductInfoResponse (ProductInfoDTO dto) {
        this.productInfoId = dto.getProductInfoId();
        this.productInfoName = dto.getProductInfoName();
        this.price = dto.getPrice();
        this.total = dto.getTotal();
        this.originalPrice = dto.getOriginalPrice();
        this.productId = dto.getProduct().getProductId();
        this.productName = dto.getProduct().getProductName();
        this.createdBy = dto.getCreatedBy();
        this.createdBy = dto.getCreatedBy();
        this.createdDate = dto.getCreatedDate();
    }

}
