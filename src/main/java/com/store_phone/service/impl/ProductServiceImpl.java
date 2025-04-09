package com.store_phone.service.impl;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public ResultDataPaging<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductDTO getProductInfo(String productId) {
        return null;
    }

    @Override
    public ProductDTO addProduct(AddProductRequest request) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(UpdateProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(String productId) {

    }
}
