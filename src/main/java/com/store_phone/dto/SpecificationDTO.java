package com.store_phone.dto;

public class SpecificationDTO extends BaseDTO {
	private String specificationsId;

    private String specificationsContent;

    private ProductDTO product;
    
    private String product_id;

	public String getSpecificationsId() {
		return specificationsId;
	}

	public void setSpecificationsId(String specificationsId) {
		this.specificationsId = specificationsId;
	}

	public String getSpecificationsContent() {
		return specificationsContent;
	}

	public void setSpecificationsContent(String specificationsContent) {
		this.specificationsContent = specificationsContent;
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
