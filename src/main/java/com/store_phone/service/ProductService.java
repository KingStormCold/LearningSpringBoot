package com.store_phone.service;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ResultDataPaging<ProductInfo> findAll(Pageable pageable);
    ProductDTO getProductInfo(String productId);
    ProductInfo addProduct (AddProductRequest request);
    ProductInfo updateProduct (UpdateProductRequest request);
    void deleteProduct (String productId);
}
