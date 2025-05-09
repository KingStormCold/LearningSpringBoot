package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.PromotionConverter;
import com.store_phone.dto.ProductDTO;
import com.store_phone.dto.PromotionDTO;
import com.store_phone.entity.PromotionEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.PromotionRespository;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.response.promotion.PromotionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.PromotionService;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRespository promotionRespository;

    @Autowired
    private PromotionConverter promotionConverter;

    @Override
    public ResultDataPaging<PromotionResponse> findAll(Pageable pageable) {
        Page<PromotionEntity> promotionEntities = promotionRespository.findAll(pageable);

        List<PromotionDTO> promotionDTOS = promotionEntities.getContent().stream().map(
                promotionEntity -> promotionConverter.convertToDto(promotionEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), promotionEntities.getTotalPages());
        List<PromotionResponse> result = promotionDTOS.stream().map(PromotionResponse::new).toList();

        return new ResultDataPaging<>(result, pagination);
    }

    @Override
    public PromotionResponse getPromotionInfo(String promotionId) {
        if (ObjectUtils.isEmpty(promotionId)) {
            throw new BadRequestException(Constants.NOT_EMPTY, "PromotionId");
        }

        PromotionDTO promotionDTO = findById(promotionId);

        if (promotionDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this promotion");
        }

        return new PromotionResponse(promotionDTO) ;
    }

    @Override
    public PromotionResponse addPromotion(AddProductRequest request) {
        return null;
    }

    @Override
    public PromotionResponse updatePromotion(UpdateProductRequest request) {
        return null;
    }

    @Override
    public void deletePromotion(String productId) {

    }

    private PromotionDTO findById(String promotionId) {
        PromotionEntity promotionEntity = promotionRespository.findById(promotionId).orElseThrow(null);
        return promotionConverter.convertToDto(promotionEntity);
    }

}
