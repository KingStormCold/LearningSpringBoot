package com.store_phone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.common.Constants;
import com.store_phone.converter.ProductConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.dto.UserDTO;
import com.store_phone.entity.ProductEntity;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.ProductRespository;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductDetail;
import com.store_phone.service.CategoryService;
import com.store_phone.service.ProductService;
import com.store_phone.service.UserService;
import com.store_phone.utils.SecurityUtils;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRespository productRespository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;

	@Override
	public ProductDTO addProduct(AddProductRequest request) {
		CategoryDTO categoryDTO = categoryService.findByCategoryId(request.getCategoryId());
		if(categoryDTO == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy danh mục.");
		}
		String userName = SecurityUtils.getCurrentUserLogin();
		UserDTO userDTO = userService.findByUserName(userName);
		if(userDTO == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy user.");
		}
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(UUID.randomUUID().toString());
		productDTO.setCategory(categoryDTO);
		productDTO.setUser(userDTO);
		productDTO.setContent(request.getContent());
		productDTO.setCreatedBy(userName);
		productDTO.setImage(request.getImage());
		productDTO.setSortDescription(request.getSortDescription());
		productDTO.setProductName(request.getProductName());
		productDTO.setInfoInsurance(request.getInfoInsurance());
		
		productRespository.save(productConverter.convertToEntity(productDTO));
		return productDTO;
	}

	@Override
	public ResultDataPaging<ProductDetail> findAllByPagination(Pageable pageable) {
		Page<ProductEntity> pageProducts = productRespository.findAll(pageable);
		List<ProductDTO> productDTOs = pageProducts.getContent().stream()
				.map(productEntity -> productConverter.convertToDto(productEntity)).toList();
		
		Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pageProducts.getTotalPages());
		List<ProductDetail> result = productDTOs.stream()
				.map(productDto -> new ProductDetail(productDto)).toList();
		return new ResultDataPaging<ProductDetail>(result, pagination);
	}

}
