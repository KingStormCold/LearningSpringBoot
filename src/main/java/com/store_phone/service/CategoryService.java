package com.store_phone.service;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.request.category.UpdateCategoryRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    ResultDataPaging<CategoryInfo> findAll (Pageable pageable);
    CategoryDTO getCategoryInfo(String categoryId);
    CategoryDTO findById(String categoryId);
    CategoryDTO addCategory(AddCategoryRequest request);
    CategoryDTO updateCategory(UpdateCategoryRequest request);
    void deleteCategory(String categoryId);
}
