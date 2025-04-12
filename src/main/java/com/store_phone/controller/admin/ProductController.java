package com.store_phone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.AddProductResponse;
import com.store_phone.response.product.ProductDetail;
import com.store_phone.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_PRODUCT')")
	@PostMapping(value = "/v1/products")
	public ResponseEntity<CommonResponse<AddProductResponse>> addProduct(@Valid @RequestBody AddProductRequest request) {
		ProductDTO productDTO = productService.addProduct(request);
		AddProductResponse response = new AddProductResponse(productDTO);
		return ResponseEntity.ok(new CommonResponse<>(response));
	}
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_PRODUCT')")
	@GetMapping(value = "/v1/products")
	public ResponseEntity<CommonResponse<ResultDataPaging<ProductDetail>>> findAllByPagination(Pageable pageable) {
		ResultDataPaging<ProductDetail> results = productService.findAllByPagination(pageable);
		return ResponseEntity.ok(new CommonResponse<>(results));
	}
}
