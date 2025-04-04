package com.store_phone.services.impl;

import com.store_phone.common.Pagination;
import com.store_phone.converters.CategoryConverter;
import com.store_phone.dtos.CategoryDTO;
import com.store_phone.entities.CategoryEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repositories.CategoryRepository;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.resquest.category.AddCategoryRequest;
import com.store_phone.resquest.category.UpdateCategoryRequest;
import com.store_phone.services.CategoryService;
import common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public ResultDataPaging<CategoryInfo> findAll(Pageable pageable) {
        Page<CategoryEntity> pageCategories = categoryRepository.findAll(pageable);

        List<CategoryDTO> categories = pageCategories.getContent().stream()
                .map(categoryEntity -> categoryConverter.converToCategoryDTO(categoryEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pageCategories.getTotalPages());
        List<CategoryInfo> result = categories.stream().map(categoryDTO -> new CategoryInfo(categoryDTO)).toList();
        return new ResultDataPaging<CategoryInfo>(result,pagination);
    }

    @Override
    public CategoryDTO getCategoryInfo(String categoryId) {
        if (ObjectUtils.isEmpty(categoryId)) {
            throw new BadRequestException(common.Constants.NOT_EMPTY, "categoryId");
        }
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElse(null);
        if (categoryEntity == null) {
            throw new UnprocessableException(common.Constants.NOT_FOUND, "Cannot find this category");
        }
        return categoryConverter.converToCategoryDTO(categoryEntity);
    }

    @Override
    public CategoryDTO addCategory(AddCategoryRequest request) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(UUID.randomUUID().toString());
        categoryEntity.setCategoryName(request.getCategoryName());
        categoryEntity.setCategoryDescription(request.getCategoryDescription());
        categoryEntity.setCategoryRoot(request.getCategoryRoot());

        categoryEntity.setCreatedDate(LocalDateTime.now());
        categoryEntity.setCreatedBy("admin");
        categoryEntity.setUpdatedDate(LocalDateTime.now());
        categoryEntity.setUpdatedBy("admin");

        categoryRepository.save(categoryEntity);
        return categoryConverter.converToCategoryDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateCategory(UpdateCategoryRequest request) {
        CategoryDTO categoryDTO = findById(request.getCategoryId());
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Category");
        }
        categoryDTO.setCategoryName(request.getCategoryName());
        categoryDTO.setCategoryDescription(request.getCategoryDescription());
        categoryDTO.setCategoryRoot(request.getCategoryRoot());
        categoryDTO.setUpdatedBy(request.getUpdatedBy());
        categoryDTO.setCreatedBy(request.getCreatedBy());
        categoryDTO.setCreatedDate(LocalDateTime.now());
        categoryDTO.setUpdatedDate(LocalDateTime.now());

        CategoryEntity categoryEntity = categoryConverter.converToCategoryEntity(categoryDTO);
        categoryRepository.save(categoryEntity);

        return categoryDTO;
    }

    @Override
    public void deleteCategory(String categoryId) {
        CategoryDTO categoryDTO = findById(categoryId);
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Category");
        }
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDTO findById(String categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElse(null);
        return categoryConverter.converToCategoryDTO(categoryEntity);
    }


}
