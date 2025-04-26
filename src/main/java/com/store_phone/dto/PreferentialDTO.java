package com.store_phone.dto;

public class PreferentialDTO extends BaseDTO{
	
	private String preferentialId;

    private String content;

    private ProductDTO product;
    
    private String product_id;

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

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	

}
