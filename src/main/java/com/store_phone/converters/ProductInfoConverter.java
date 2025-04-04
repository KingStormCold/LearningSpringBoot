package com.store_phone.converters;

import com.store_phone.dtos.ProductDTO;
import com.store_phone.dtos.ProductInfoDTO;
import com.store_phone.entities.ProductEntity;
import com.store_phone.entities.ProductInfoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Configuration
public class ProductInfoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductInfoDTO converToProductInfoDTO (ProductInfoEntity productInfoEntity) {
        if (ObjectUtils.isEmpty(productInfoEntity)) {
            return null;
        }
        return modelMapper.map(productInfoEntity, ProductInfoDTO.class);
    }

    public ProductInfoEntity converToProductInfoEntity (ProductInfoDTO productInfoDTO) {
        return modelMapper.map(productInfoDTO, ProductInfoEntity.class);
    }

}
