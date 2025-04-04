package com.store_phone.services.impl;

import com.store_phone.common.Pagination;
import com.store_phone.converters.CategoryConverter;
import com.store_phone.converters.ProductConverter;
import com.store_phone.converters.UserConverter;
import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.ProductDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.entities.CategoryEntity;
import com.store_phone.entities.ProductEntity;
import com.store_phone.entities.UserEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repositories.ProductRepository;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.resquest.product.AddProductRequest;
import com.store_phone.resquest.product.UpdateProductRequest;
import com.store_phone.services.CategoryService;
import com.store_phone.services.ProductService;
import com.store_phone.services.UserService;
import common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Override
    public ResultDataPaging<ProductInfo> findAll(Pageable pageable) {
        Page<ProductEntity> pageProducts = productRepository.findAll(pageable);

        List<ProductDTO> products = pageProducts.getContent().stream().map(
                productEntity -> productConverter.convertToProductDTO(productEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pageProducts.getTotalPages());
        List<ProductInfo> result = products.stream().map(productDTO -> new ProductInfo(productDTO)).toList();
        return new ResultDataPaging<ProductInfo>(result,pagination);
    }

    @Override
    public ProductDTO getProductInfo(String productId) {
        if (ObjectUtils.isEmpty(productId)) {
            throw new BadRequestException(common.Constants.NOT_EMPTY, "ProductId");
        }
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);
        if (productEntity == null) {
            throw new UnprocessableException(common.Constants.NOT_FOUND, "Cannot find this product");
        }
        return productConverter.convertToProductDTO(productEntity);
    }

    @Override
    public ProductDTO addProduct(AddProductRequest request) {
        //1.check coi sản phẩm đó có chưa
        //2.tạo new ProductDTO : dto.set các field
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(UUID.randomUUID().toString());
        productDTO.setProductName(request.getProductName());
        productDTO.setContent(request.getContent());
        productDTO.setShortDescription(request.getShortDescription());
        productDTO.setImage(request.getImage());
        productDTO.setInfoBox(request.getInfoBox());
        productDTO.setInfoInsurance(request.getInfoInsurance());
        productDTO.setCreatedBy("toan_01");
        productDTO.setUpdatedBy("toan_01");
        productDTO.setCreatedDate(LocalDateTime.now());
        productDTO.setUpdatedDate(LocalDateTime.now());

        //3.convert DTO sang Entity rồi repository.save -> return DTO ra
        ProductEntity productEntity = productConverter.converToProductEntity(productDTO);

        //4.xử lý các bảng liên kết
        CategoryDTO categoryDTO = categoryService.findById(request.getCategoryId());
        UserDTO userDTO = userService.findByUserName(request.getUserName());

        CategoryEntity categoryEntity = categoryConverter.converToCategoryEntity(categoryDTO);
        UserEntity userEntity = userConverter.converToEntity(userDTO);

        productEntity.setCategory(categoryEntity);
        productEntity.setUser(userEntity);

        productRepository.save(productEntity);
        return productConverter.convertToProductDTO(productEntity);
    }

    @Override
    public ProductDTO updateProduct(UpdateProductRequest request) {
        CategoryDTO categoryDTO = categoryService.findById(request.getCategoryId());
        if (categoryDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this Category");
        }
        // 1. tìm san pham
        ProductDTO productDTO = findById(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this Product");
        }

        // 2. sửa thông tin
        productDTO.setProductName(request.getProductName());
        productDTO.setContent(request.getContent());
        productDTO.setShortDescription(request.getShortDescription());
        productDTO.setImage(request.getImage());
        productDTO.setInfoBox(request.getInfoBox());
        productDTO.setInfoInsurance(request.getInfoInsurance());
        productDTO.setUpdatedBy("trung_01");
        productDTO.setUpdatedDate(LocalDateTime.now());

        // 3. Convert lại sang Entity
        ProductEntity productEntity = productConverter.converToProductEntity(productDTO);

        // 4. Gán Category & User
        //check category != null

        UserDTO userDTO = userService.findByUserName(request.getUserName());

        CategoryEntity categoryEntity = categoryConverter.converToCategoryEntity(categoryDTO);
        UserEntity userEntity = userConverter.converToEntity(userDTO);

        productEntity.setCategory(categoryEntity);
        productEntity.setUser(userEntity);

        // 5. Save
        productRepository.save(productEntity);

        return productConverter.convertToProductDTO(productEntity);
    }

    @Override
    public void deleteProduct(String productId) {
        ProductDTO productDTO = findById(productId);
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this Product to remove");
        }
        productRepository.deleteById(productId);
    }

    private ProductDTO findById (String productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);
        return productConverter.convertToProductDTO(productEntity);
    }

}
