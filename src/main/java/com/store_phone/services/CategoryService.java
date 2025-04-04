package com.store_phone.services;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.RoleDTO;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.resquest.category.AddCategoryRequest;
import com.store_phone.resquest.category.UpdateCategoryRequest;
import com.store_phone.resquest.role.UpdateRoleRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    ResultDataPaging<CategoryInfo> findAll(Pageable pageable);
    CategoryDTO getCategoryInfo(String categoryId);
    CategoryDTO findById(String categoryId);
    CategoryDTO addCategory(AddCategoryRequest request);
    CategoryDTO updateCategory(UpdateCategoryRequest request);
    void deleteCategory(String categoryId);
}
