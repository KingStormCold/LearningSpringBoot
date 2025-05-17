package com.store_phone.service;

import com.store_phone.dto.ProductInfoDetailDTO;
import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info_detail.AddProductInfoDetail;
import com.store_phone.request.product_info_detail.UpdateProductInfoDetail;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info_detail.ProductInfoDetailResponse;
import org.springframework.data.domain.Pageable;

public interface ProductInfoDetailSerivce {
    ResultDataPaging<ProductInfoDetailResponse> findAll(Pageable pageable);
    ProductInfoDetailResponse getProductInfoDetail (String productInfoDetailId);
    ProductInfoDetailResponse addProductInfoDetail (AddProductInfoDetail request);
    ProductInfoDetailResponse updateProductInfoDetail (UpdateProductInfoDetail request);
    void deleteProductInfoDetail (String productInfoDetailId);

}
