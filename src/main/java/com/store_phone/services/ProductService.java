package com.store_phone.services;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.ProductDTO;
import com.store_phone.dtos.ProductInfoDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.response.user.UserInfo;
import com.store_phone.resquest.product.AddProductRequest;
import com.store_phone.resquest.product.UpdateProductRequest;
import com.store_phone.resquest.user.AddUserRequest;
import com.store_phone.resquest.user.UpdateUserRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ResultDataPaging<ProductInfo> findAll(Pageable pageable);
    ProductDTO getProductInfo(String productId);
    ProductDTO addProduct (AddProductRequest request);
    ProductDTO updateProduct (UpdateProductRequest request);
    void deleteProduct (String productId);

}
