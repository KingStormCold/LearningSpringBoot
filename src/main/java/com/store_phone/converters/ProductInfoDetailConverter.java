package com.store_phone.converters;

import com.store_phone.dtos.ProductInfoDetailDTO;
import com.store_phone.entities.ProductInfoDetailEntity;
import com.store_phone.services.impl.ProductInfoDetailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Configuration
public class ProductInfoDetailConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductInfoDetailDTO convertToProductInfoDetailDTO (ProductInfoDetailEntity productInfoDetailEntity) {
        if (ObjectUtils.isEmpty(productInfoDetailEntity)) {
            return null;
        }
        return modelMapper.map(productInfoDetailEntity, ProductInfoDetailDTO.class);
    }

    public ProductInfoDetailEntity convertToProductInfoDetail (ProductInfoDetailDTO productInfoDetailDTO) {
        return modelMapper.map(productInfoDetailDTO, ProductInfoDetailEntity.class);
    }

}
