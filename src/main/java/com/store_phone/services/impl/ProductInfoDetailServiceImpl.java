package com.store_phone.services.impl;

import com.store_phone.converters.ProductInfoDetailConverter;
import com.store_phone.dtos.ProductInfoDetailDTO;
import com.store_phone.entities.ProductInfoDetailEntity;
import com.store_phone.repositories.ProductInfoDetailRepository;
import com.store_phone.services.ProductInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInfoDetailServiceImpl implements ProductInfoDetailService {

    @Autowired
    private ProductInfoDetailRepository productInfoDetailRepository;

    @Autowired
    private ProductInfoDetailConverter productInfoDetailConverter;


    @Override
    public List<ProductInfoDetailDTO> findAll() {
        List<ProductInfoDetailEntity> productInfoDetails = productInfoDetailRepository.findAll();
        List<ProductInfoDetailDTO> productInfoDetailDTOS = new ArrayList<>();
        for (ProductInfoDetailEntity entity : productInfoDetails) {
            productInfoDetailDTOS.add(productInfoDetailConverter.convertToProductInfoDetailDTO(entity));
        }
        return productInfoDetailDTOS;
    }
}
