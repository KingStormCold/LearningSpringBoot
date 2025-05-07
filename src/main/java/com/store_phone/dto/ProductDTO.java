package com.store_phone.dto;

import java.util.Set;

public class ProductDTO extends BaseDTO {

	private String productId;

    private String productName;

    private String sortDescription;

    private String content;

    private String image;

    private String originalPrice;

    private String discountPrice;

    private String infoBox;

    private String infoInsurance;

    private String total;

    private CategoryDTO category;

    private UserDTO user;

    private SpecificationDTO specifications;
    
    private Set<ProductInfoDTO> productInfo;
    
    private PreferentialDTO preferentialDTO;

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

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public SpecificationDTO getSpecifications() {
		return specifications;
	}

	public void setSpecifications(SpecificationDTO specifications) {
		this.specifications = specifications;
	}

	public Set<ProductInfoDTO> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Set<ProductInfoDTO> productInfo) {
		this.productInfo = productInfo;
	}

	public PreferentialDTO getPreferentialDTO() {
		return preferentialDTO;
	}

	public void setPreferentialDTO(PreferentialDTO preferentialDTO) {
		this.preferentialDTO = preferentialDTO;
	}
}
