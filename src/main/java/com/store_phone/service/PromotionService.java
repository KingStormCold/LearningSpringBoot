package com.store_phone.service;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.response.promotion.PromotionResponse;
import org.springframework.data.domain.Pageable;

public interface PromotionService {
    ResultDataPaging<PromotionResponse> findAll(Pageable pageable);
    PromotionResponse getPromotionInfo(String productId);
    PromotionResponse addPromotion (AddProductRequest request);
    PromotionResponse updatePromotion (UpdateProductRequest request);
    void deletePromotion (String productId);
}
