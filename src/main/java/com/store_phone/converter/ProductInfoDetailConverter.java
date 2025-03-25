package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.ProductInfoDetailDTO;
import com.store_phone.entity.ProductInfoDetailEntity;

@Component
public class ProductInfoDetailConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public ProductInfoDetailEntity convertToEntity(ProductInfoDetailDTO dto) {
        ProductInfoDetailEntity result = modelMapper.map(dto, ProductInfoDetailEntity.class);
        return result;
    }

    public ProductInfoDetailDTO convertToDto(ProductInfoDetailEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        ProductInfoDetailDTO result = modelMapper.map(entity, ProductInfoDetailDTO.class);
        return result;
    }

}
