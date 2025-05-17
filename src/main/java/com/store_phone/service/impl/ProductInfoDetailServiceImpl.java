package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.ProductInfoDetailConverter;
import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.dto.ProductInfoDetailDTO;
import com.store_phone.entity.ProductInfoDetailEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.ProductInfoDetailRepository;
import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info_detail.AddProductInfoDetail;
import com.store_phone.request.product_info_detail.UpdateProductInfoDetail;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info.ProductInfoResponse;
import com.store_phone.response.product_info_detail.ProductInfoDetailResponse;
import com.store_phone.service.ProductInfoService;
import com.store_phone.service.ProductService;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.store_phone.service.ProductInfoDetailSerivce;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductInfoDetailServiceImpl implements ProductInfoDetailSerivce{

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductInfoDetailRepository productInfoDetailRepository;

    @Autowired
    private ProductInfoDetailConverter productInfoDetailConverter;

    @Override
    public ResultDataPaging<ProductInfoDetailResponse> findAll(Pageable pageable) {
        Page<ProductInfoDetailEntity> entities = productInfoDetailRepository.findAll(pageable);

        List<ProductInfoDetailDTO> dtos = entities.getContent().stream().map(
               entity -> productInfoDetailConverter.convertToDto(entity)
        ).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), entities.getTotalPages());
        List<ProductInfoDetailResponse> result = dtos.stream().map(dto -> new ProductInfoDetailResponse(dto)).toList();

        return new ResultDataPaging<>(result, pagination);
    }

    @Override
    public ProductInfoDetailResponse getProductInfoDetail (String productInfoDetailId) {
        if (ObjectUtils.isEmpty(productInfoDetailId)) {
            throw new BadRequestException(Constants.NOT_EMPTY, "productInfoDetailId");
        }

        ProductInfoDetailDTO dto = findById(productInfoDetailId);
        if (dto == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY, "Cannot find this ProductInfoDetail");
        }

        return new ProductInfoDetailResponse(dto);
    }

    @Override
    public ProductInfoDetailResponse addProductInfoDetail(AddProductInfoDetail request) {

        ProductInfoDTO productInfoDTO = productInfoService.getProductInfo(request.getProductInfoId());
        if (productInfoDTO == null) {
            throw new BadRequestException(Constants.NOT_EMPTY, "Cannot find this Product Info to create Product Info Detail");
        }

        ProductInfoDetailDTO newProductInfoDetail = new ProductInfoDetailDTO();

        newProductInfoDetail.setProductInfoDetailId(UUID.randomUUID().toString());
        newProductInfoDetail.setName(request.getName());
        newProductInfoDetail.setImages(request.getImages());
        newProductInfoDetail.setBestseller(request.getBestSeller());
        newProductInfoDetail.setBuyNowPrice(request.getBuyNowPrice());
        newProductInfoDetail.setPriceAfterDiscount(request.getPriceAfterDiscount());
        newProductInfoDetail.setTotal(request.getTotal());
        newProductInfoDetail.setInstallmentPrice(request.getInstallmentPrice());
        newProductInfoDetail.setDiscountPrice(request.getDiscountPrice());

        newProductInfoDetail.setProductInfo(productInfoDTO);

        newProductInfoDetail.setCreatedBy(SecurityUtils.getCurrentUserLogin());
        newProductInfoDetail.setCreatedDate(LocalDateTime.now());
        newProductInfoDetail.setUpdatedBy(null);
        newProductInfoDetail.setUpdatedDate(null);

        ProductInfoDetailEntity entity = productInfoDetailConverter.convertToEntity(newProductInfoDetail);
        productInfoDetailRepository.save(entity);

        ProductInfoDetailDTO dto = productInfoDetailConverter.convertToDto(entity);
        return new ProductInfoDetailResponse(dto);
    }

    @Override
    public ProductInfoDetailResponse updateProductInfoDetail(UpdateProductInfoDetail request) {

        ProductInfoDTO productInfoDTO = productInfoService.getProductInfo(request.getProductInfoId());
        if (productInfoDTO == null) {
            throw new BadRequestException(Constants.NOT_EMPTY, "Cannot find this Product Info to create Product Info Detail");
        }

        ProductInfoDetailDTO productInfoDetailDTO = findById(request.getProductInfoDetailId());

        if (productInfoDetailDTO == null) {
            throw new BadRequestException(Constants.NOT_EMPTY, "Cannot find this ProductInfoDetail");
        }

        productInfoDetailDTO.setName(request.getName());
        productInfoDetailDTO.setImages(request.getImages());
        productInfoDetailDTO.setBestseller(request.getBestSeller());
        productInfoDetailDTO.setBuyNowPrice(request.getBuyNowPrice());
        productInfoDetailDTO.setPriceAfterDiscount(request.getPriceAfterDiscount());
        productInfoDetailDTO.setTotal(request.getTotal());
        productInfoDetailDTO.setInstallmentPrice(request.getInstallmentPrice());
        productInfoDetailDTO.setDiscountPrice(request.getDiscountPrice());

        productInfoDetailDTO.setProductInfo(productInfoDTO);

        productInfoDetailDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
        productInfoDetailDTO.setUpdatedDate(LocalDateTime.now());

        ProductInfoDetailEntity entity = productInfoDetailConverter.convertToEntity(productInfoDetailDTO);
        productInfoDetailRepository.save(entity);

        ProductInfoDetailDTO dto = productInfoDetailConverter.convertToDto(entity);
        return new ProductInfoDetailResponse(dto);
    }

    @Override
    public void deleteProductInfoDetail(String productInfoDetailId) {
        ProductInfoDetailDTO dto = findById(productInfoDetailId);
        if (dto == null) {
            throw new BadRequestException(Constants.NOT_EMPTY, "Cannot find this ProductInfoDetail to Remove");
        }
        productInfoDetailRepository.deleteById(productInfoDetailId);
    }

    private ProductInfoDetailDTO findById (String productInfoDetailId) {
        ProductInfoDetailEntity entity = productInfoDetailRepository.findById(productInfoDetailId).orElse(null);
        if (entity == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Product info Detail");
        }
        ProductInfoDetailDTO dto = productInfoDetailConverter.convertToDto(entity);
        return dto;
    }
}
