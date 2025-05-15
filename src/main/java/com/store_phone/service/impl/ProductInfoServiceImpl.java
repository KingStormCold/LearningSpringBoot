package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.ProductInfoConverter;
import com.store_phone.dto.ProductDTO;
import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.entity.ProductInfoEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.ProductInfoRespository;
import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info.UpdateProductInfoRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info.ProductInfoResponse;
import com.store_phone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.ProductInfoService;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Autowired
    private ProductService productService;


    @Autowired
    private ProductInfoConverter productInfoConverter;

    @Override
    public ResultDataPaging<ProductInfoResponse> findAll(Pageable pageable) {
        Page<ProductInfoEntity> productInfoEntityPage = productInfoRespository.findAll(pageable);

        List<ProductInfoDTO> listDTO = productInfoEntityPage.getContent().stream().map(
          entity -> productInfoConverter.convertToDto(entity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), productInfoEntityPage.getTotalPages());
        List<ProductInfoResponse> resutl = listDTO.stream().map(dto -> new ProductInfoResponse(dto)).toList();

        return new ResultDataPaging<>(resutl, pagination);
    }

    @Override
    public ProductInfoDTO getProductInfo(String productInfoId) {
        if (ObjectUtils.isEmpty(productInfoId)) {
            throw new BadRequestException(Constants.NOT_EMPTY,"ProductInfoId");
        }
        ProductInfoDTO productInfoDTO = findById(productInfoId);
        if (productInfoDTO == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this ProductInfo");
        }
        return productInfoDTO;
    }

    @Override
    public ProductInfoResponse addProductInfo(AddProductInfoRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this product to create ProductInfo");
        }

        ProductInfoDTO newProductInfo = new ProductInfoDTO();

        newProductInfo.setProductInfoId(UUID.randomUUID().toString());
        newProductInfo.setProductInfoName(request.getProductInfoName());
        newProductInfo.setProduct(productDTO);
        newProductInfo.setPrice(request.getPrice());
        newProductInfo.setTotal(request.getTotal());
        newProductInfo.setOriginalPrice(request.getOriginal_price());

        ProductInfoEntity entity = productInfoConverter.convertToEntity(newProductInfo);
        productInfoRespository.save(entity);

        ProductInfoDTO dto = productInfoConverter.convertToDto(entity);

        return new ProductInfoResponse(dto);
    }

    @Override
    public ProductInfoResponse updateProductInfo(UpdateProductInfoRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this product to create ProductInfo");
        }


        return null;
    }

    @Override
    public void deleteProduct(String productId) {

    }

    private ProductInfoDTO findById(String productInfoId) {
        ProductInfoEntity result = productInfoRespository.findById(productInfoId).orElse(null);
        return productInfoConverter.convertToDto(result);
    }
}
