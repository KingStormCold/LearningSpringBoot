package com.store_phone.dto;

public class PreferentialDTO extends BaseDTO{
	
	private String preferentialId;

    private String content;

    private ProductDTO product;
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
