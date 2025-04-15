package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.ProductConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.entity.ProductEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.ProductRespository;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.service.CategoryService;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.ProductService;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResultDataPaging<ProductInfo> findAll(Pageable pageable) {
        Page<ProductEntity> pageProducts = productRespository.findAll(pageable);

        List<ProductDTO> productDTOS = pageProducts.getContent().stream()
                .map(productEntity -> productConverter.convertToDto(productEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(),pageProducts.getTotalPages());
        List<ProductInfo> result = productDTOS.stream().map(productDTO -> new ProductInfo(productDTO)).toList();

        return new ResultDataPaging<>(result, pagination);
    }

    @Override
    public ProductDTO getProductInfo(String productId) {
        if (ObjectUtils.isEmpty(productId)) {
            throw new BadRequestException(Constants.NOT_EMPTY, "ProductId");
        }
        ProductEntity productEntity = productRespository.findById(productId).orElse(null);
        if (productEntity == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this Product");
        }

        return productConverter.convertToDto(productEntity);
    }

    @Override
    public ProductDTO addProduct(AddProductRequest request) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(UUID.randomUUID().toString());
        productDTO.setProductName(request.getProductName());
        productDTO.setContent(request.getContent());
        productDTO.setSortDescription(request.getShortDescription());
        productDTO.setImage(request.getImage());
        productDTO.setInfoBox(request.getInfoBox());
        productDTO.setInfoInsurance(request.getInfoInsurance());
        productDTO.setCreatedBy(SecurityUtils.getCurrentUserLogin());

        ProductEntity productEntity = productConverter.convertToEntity(productDTO);
        productRespository.save(productEntity);

        return productConverter.convertToDto(productEntity);
    }

    @Override
    public ProductDTO updateProduct(UpdateProductRequest request) {
        CategoryDTO categoryDTO = categoryService.findById(request.getCategoryId());
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this Category");
        }

        ProductDTO productDTO = findById(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this product");
        }

        productDTO.setProductName(request.getProductName());
        productDTO.setContent(request.getContent());
        productDTO.setSortDescription(request.getShortDescription());
        productDTO.setImage(request.getImage());
        productDTO.setInfoBox(request.getInfoBox());
        productDTO.setInfoInsurance(request.getInfoInsurance());

        ProductEntity productEntity = productConverter.convertToEntity(productDTO);

        productRespository.save(productEntity);

        return productConverter.convertToDto(productEntity);
    }

    @Override
    public void deleteProduct(String productId) {
        ProductDTO productDTO = findById(productId);
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this Product to remove");
        }
        productRespository.deleteById(productId);

    }

    private ProductDTO findById (String productId) {
        ProductEntity productEntity = productRespository.findById(productId).orElse(null);
        return productConverter.convertToDto(productEntity);

    }


}
