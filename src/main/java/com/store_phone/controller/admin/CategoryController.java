package com.store_phone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.AddCategoryResponse;
import com.store_phone.response.category.CategoryDetail;
import com.store_phone.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_CATEGORY')")
	@PostMapping(value = "/v1/categories")
	public ResponseEntity<CommonResponse<AddCategoryResponse>> addCategory(@Valid @RequestBody AddCategoryRequest resquest) {
		CategoryDTO categoryDTO = categoryService.addCategory(resquest);
		AddCategoryResponse response = new AddCategoryResponse(categoryDTO);
		return ResponseEntity.ok(new CommonResponse<>(response));
	}
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_CATEGORY')")
	@GetMapping(value = "/v1/categories")
	public ResponseEntity<CommonResponse<ResultDataPaging<CategoryDetail>>> findAllByPagination(Pageable pageable) {
		ResultDataPaging<CategoryDetail> results = categoryService.findAllByPagination(pageable);
		return ResponseEntity.ok(new CommonResponse<>(results));
	}
}
