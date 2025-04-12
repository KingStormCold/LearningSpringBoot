package com.store_phone.service;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryDetail;

public interface CategoryService {

	CategoryDTO addCategory(AddCategoryRequest request);
	
	ResultDataPaging<CategoryDetail> findAllByPagination(Pageable pageable);
	
	CategoryDTO findByCategoryId(String id);
}
