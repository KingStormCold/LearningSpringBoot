package com.store_phone.converters;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.entities.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Configuration
public class CategoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO converToCategoryDTO (CategoryEntity categoryEntity) {
        if (ObjectUtils.isEmpty(categoryEntity)) {
            return null;
        }
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    public CategoryEntity converToCategoryEntity (CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }
}
