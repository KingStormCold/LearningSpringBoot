package com.store_phone.service;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductDetail;

public interface ProductService {

	ProductDTO addProduct(AddProductRequest request);
	
	ResultDataPaging<ProductDetail> findAllByPagination(Pageable pageable);
	
	ProductDTO getProductById (String productId);
	
	ProductDTO updateProduct(UpdateProductRequest request, String productId);
	
	void deleteProduct(String productId);
	
}
