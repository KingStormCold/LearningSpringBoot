package com.store_phone.service;

import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info.UpdateProductInfoRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info.ProductInfoResponse;
import org.springframework.data.domain.Pageable;

public interface ProductInfoService {
    ResultDataPaging<ProductInfoResponse> findAll(Pageable pageable);
    ProductInfoDTO getProductInfo(String productInfoId);
    ProductInfoResponse addProductInfo (AddProductInfoRequest request);
    ProductInfoResponse updateProductInfo (UpdateProductInfoRequest request);
    void deleteProductInfo (String productId);

}
