package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	@Autowired
    private ModelMapper modelMapper;
    
    public CategoryEntity convertToEntity(CategoryDTO dto) {
        CategoryEntity result = modelMapper.map(dto, CategoryEntity.class);
        return result;
    }
    
    public CategoryDTO convertToDto(CategoryEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        CategoryDTO result = modelMapper.map(entity, CategoryDTO.class);
        return result;
    }

}
