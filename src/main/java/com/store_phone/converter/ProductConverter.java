package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.ProductDTO;
import com.store_phone.entity.ProductEntity;

@Component
public class ProductConverter {

	@Autowired
    private ModelMapper modelMapper;

    public ProductEntity convertToEntity(ProductDTO dto) {
        ProductEntity result = modelMapper.map(dto, ProductEntity.class);
        return result;
    }

    public ProductDTO convertToDto(ProductEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        ProductDTO result = modelMapper.map(entity, ProductDTO.class);
        return result;
    }
}
