package com.store_phone.dto;

public class ProductInfoDetailDTO extends BaseDTO{
	
	private String productInfoDetailId;

    private ProductInfoDTO productInfo;

    private String name;

    private String images;

    private String total;

    private Long buyNowPrice;

    private Long installmentPrice;
    
    private Long discountPrice;
    
    private Long priceAfterDiscount;
    
    private Boolean bestseller;

	public String getProductInfoDetailId() {
		return productInfoDetailId;
	}

	public void setProductInfoDetailId(String productInfoDetailId) {
		this.productInfoDetailId = productInfoDetailId;
	}

	public ProductInfoDTO getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfoDTO productInfo) {
		this.productInfo = productInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Long getBuyNowPrice() {
		return buyNowPrice;
	}

	public void setBuyNowPrice(Long buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}

	public Long getInstallmentPrice() {
		return installmentPrice;
	}

	public void setInstallmentPrice(Long installmentPrice) {
		this.installmentPrice = installmentPrice;
	}

	public Long getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Long discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Long priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public Boolean getBestseller() {
		return bestseller;
	}

	public void setBestseller(Boolean bestseller) {
		this.bestseller = bestseller;
	}

}
