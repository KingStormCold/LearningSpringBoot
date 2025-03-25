package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.entity.ProductInfoEntity;

@Component
public class ProductInfoConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public ProductInfoEntity convertToEntity(ProductInfoDTO dto) {
        ProductInfoEntity result = modelMapper.map(dto, ProductInfoEntity.class);
        return result;
    }

    public ProductInfoDTO convertToDto(ProductInfoEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        ProductInfoDTO result = modelMapper.map(entity, ProductInfoDTO.class);
        return result;
    }

}
