 package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.ProductConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.dto.UserDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.ProductService;
import com.store_phone.service.UserService;
import com.store_phone.utils.SecurityUtils;

import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
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

    @Autowired
    private UserService userService;

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
        ProductDTO productDTO = findById(productId);
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this Product");
        }

        return productDTO;
    }

    @Override
    public ProductInfo addProduct(AddProductRequest request) {
        CategoryDTO categoryDTO = categoryService.findById(request.getCategoryId());
        if(categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find category.");
        }
        String userName = SecurityUtils.getCurrentUserLogin();
        UserDTO userDTO = userService.findByUserName(userName);
        if(userDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find user.");
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(UUID.randomUUID().toString());
        productDTO.setProductName(request.getProductName());
        productDTO.setContent(request.getContent());
        productDTO.setSortDescription(request.getShortDescription());
        productDTO.setImage(request.getImage());
        productDTO.setInfoBox(request.getInfoBox());
        productDTO.setInfoInsurance(request.getInfoInsurance());

        productDTO.setCategory(categoryDTO);

        userDTO.setUserName(SecurityUtils.getCurrentUserLogin());
        productDTO.setUser(userDTO);
//        productDTO.setCreatedBy(SecurityUtils.getCurrentUserLogin());
//        productDTO.setUpdatedBy(null);
        productDTO.setCreatedDate(LocalDateTime.now());
//        productDTO.setUpdatedDate(null);

        ProductEntity productEntity = productConverter.convertToEntity(productDTO);
        productRespository.save(productEntity);

        ProductDTO saveProductDTO = productConverter.convertToDto(productEntity);
        return new ProductInfo(saveProductDTO);
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
