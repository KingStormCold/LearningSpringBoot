package com.store_phone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.store_phone.common.Constants;
import com.store_phone.converter.CategoryConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.entity.CategoryEntity;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.CategoryRespository;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.request.category.UpdateCategoryRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryDetail;
import com.store_phone.service.CategoryService;
import com.store_phone.utils.SecurityUtils;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRespository categoryRespository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public CategoryDTO addCategory(AddCategoryRequest request) {
		if(!ObjectUtils.isEmpty(request.getCategoryRoot())) {
			// categoryRespository.findById = select * from Category where category_id = ""
			CategoryEntity categoryRoot = categoryRespository.findById(request.getCategoryRoot()).orElse(null);
			if(categoryRoot == null) {
				throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy danh mục cha.");
			}
		}
		
		CategoryDTO newCategory = new CategoryDTO();
		newCategory.setCategoryId(UUID.randomUUID().toString());
		newCategory.setCategoryName(request.getCategoryName());
		newCategory.setCategoryDescription(request.getCategoryDescription());
		newCategory.setCategoryRoot(request.getCategoryRoot() != null ? request.getCategoryRoot() : "");
		newCategory.setDisplayInSlider(request.getDisplayInSlider());
		newCategory.setCreatedBy(SecurityUtils.getCurrentUserLogin());
		
		categoryRespository.save(categoryConverter.convertToEntity(newCategory));
		return newCategory;
	}

	@Override
	public ResultDataPaging<CategoryDetail> findAllByPagination(Pageable pageable) {
		Page<CategoryEntity> pageCategories = categoryRespository.findAll(pageable);
		List<CategoryDTO> categoryDTOs = pageCategories.getContent().stream()
				.map(category -> categoryConverter.convertToDto(category)).toList();
		Pagination pagination = new Pagination(pageable.getPageNumber(), 
				pageable.getPageSize(), pageCategories.getTotalPages());
//		List<CategoryDetail> result = categoryDTOs.stream()
//				.map(categoryDTO -> new CategoryDetail(categoryDTO, 
//						findByCategoryId(categoryDTO.getCategoryRoot()))).toList();
		
		List<CategoryDetail> result = categoryDTOs.stream()
				.map(categoryDTO -> {
					CategoryDTO categoryRoot = findByCategoryId(categoryDTO.getCategoryRoot());
					CategoryDetail categoryDetail = new CategoryDetail(categoryDTO,
							categoryRoot == null ? "" : categoryRoot.getCategoryName());
					return categoryDetail;
				}).toList();
		return new ResultDataPaging<CategoryDetail>(result, pagination);
	}

	@Override
	public CategoryDTO findByCategoryId(String id) {
		CategoryEntity entity = categoryRespository.findById(id).orElse(null);
		return categoryConverter.convertToDto(entity);
	}

	@Override
	public void deleCategoryById(String categoryId) {
		if (categoryId == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy categoryId");
		}
		categoryRespository.deleteById(categoryId);
		
	}

	@Override
	public CategoryDTO updateCategory(UpdateCategoryRequest request) {
		CategoryEntity entity = categoryRespository.findById(request.getCategoryName()).orElse(null);
		if (entity == null) {
			return null;
		}
		entity.setCategoryName(request.getCategoryName());
		entity.setCategoryDescription(request.getCategoryDescription());
		entity.setCategoryRoot(request.getCategoryRoot());
		entity.setDisplayInSlider(request.getDisplayInSlider());
		categoryRespository.save(entity);
		return categoryConverter.convertToDto(entity);
	}
	

	

}
