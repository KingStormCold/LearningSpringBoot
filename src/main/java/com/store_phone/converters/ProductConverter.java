package com.store_phone.converters;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.ProductDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.Set;

@Configuration
public class ProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertToProductDTO (ProductEntity productEntity) {
        if (ObjectUtils.isEmpty(productEntity)) {
            return null;
        }
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public ProductEntity converToProductEntity (ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }

}
