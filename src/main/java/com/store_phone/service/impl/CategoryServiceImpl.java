package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.CategoryConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.entity.CategoryEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.CategoryRespository;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.request.category.UpdateCategoryRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.CategoryService;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRespository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public ResultDataPaging<CategoryInfo> findAll(Pageable pageable) {
        Page<CategoryEntity> pageCategories = categoryRepository.findAll(pageable);

        List<CategoryDTO> categories = pageCategories.getContent().stream()
                .map(categoryEntity -> categoryConverter.convertToDto(categoryEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageCategories.getSize(), pageCategories.getTotalPages());
        List<CategoryInfo> result = categories.stream().map(categoryDTO -> new CategoryInfo(categoryDTO)).toList();

        return new ResultDataPaging<CategoryInfo>(result, pagination);
    }

    @Override
    public CategoryDTO getCategoryInfo(String categoryId) {
        if (ObjectUtils.isEmpty(categoryId)) {
            throw new BadRequestException(Constants.NOT_FOUND,"categoryId");
        }
        CategoryDTO categoryDTO = findById(categoryId);
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this category!");
        }
        return categoryDTO;
    }

    @Override
    public CategoryDTO findById(String categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElse(null);
        return categoryConverter.convertToDto(categoryEntity);
    }

    @Override
    public CategoryDTO addCategory(AddCategoryRequest request) {
        if (request.getCategoryRoot() != null) {
        	CategoryDTO categoryRoot = findById(request.getCategoryRoot());
            if (categoryRoot == null) {
                throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find the Root Category");
            }
        }

        CategoryDTO newCategory = new CategoryDTO();
        newCategory.setCategoryId(UUID.randomUUID().toString());
        newCategory.setCategoryName(request.getCategoryName());
        newCategory.setCategoryDescription(request.getCategoryDescription());
        newCategory.setCategoryRoot(request.getCategoryRoot() != null ? request.getCategoryRoot() : "");
        newCategory.setDisplayInSlider(true);// phải lấy từ request hk dc để mặc định là true
        newCategory.setCreatedBy(SecurityUtils.getCurrentUserLogin());

        categoryRepository.save(categoryConverter.convertToEntity(newCategory));
        return newCategory;
    }

    @Override
    public CategoryDTO updateCategory(UpdateCategoryRequest request) {
        CategoryDTO categoryDTO = findById(request.getCategoryId());
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this category");
        }
        if(!ObjectUtils.isEmpty(request.getCategoryRoot())) {
        	CategoryDTO category = findById(request.getCategoryRoot());
    		if(category == null) {
    			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy danh mục.");
    		}
        }
        
        categoryDTO.setCategoryName(request.getCategoryName());
        categoryDTO.setCategoryDescription(request.getCategoryDescription());
        categoryDTO.setCategoryRoot(request.getCategoryRoot());
        // phải lấy từ request hk dc để mặc định là true categoryDTO.setDisplayInSlider(true);
        categoryDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());

        CategoryEntity categoryEntity = categoryConverter.convertToEntity(categoryDTO);
        categoryRepository.save(categoryEntity);

        return categoryDTO;
    }

    @Override
    public void deleteCategory(String categoryId) {
        CategoryDTO categoryDTO = findById(categoryId);
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this category!");
        }
        categoryRepository.deleteById(categoryId);
    }
}
