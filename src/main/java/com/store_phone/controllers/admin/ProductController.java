package com.store_phone.controllers.admin;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.ProductDTO;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.resquest.category.UpdateCategoryRequest;
import com.store_phone.resquest.product.AddProductRequest;
import com.store_phone.resquest.product.UpdateProductRequest;
import com.store_phone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("v1/product/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<ProductInfo>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(productService.findAll(pageable)));
    }

    @GetMapping(value = "v1/product/{productId}")
    public ResponseEntity<CommonResponse<ProductInfo>> findById(@PathVariable("productId") String productId) {
        ProductDTO productDTO = productService.getProductInfo(productId);
        ProductInfo productInfo = new ProductInfo(productDTO);
        return ResponseEntity.ok(new CommonResponse<>(productInfo));
    }

    @PostMapping(value = "v1/product/create")
    public ResponseEntity<CommonResponse<ProductDTO>> addProduct (@Valid @RequestBody AddProductRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(productService.addProduct(request)));
    }

    @PutMapping(value = "v1/product/update")
    public ResponseEntity<CommonResponse<ProductInfo>> updateUser(@Valid @RequestBody UpdateProductRequest request) {
        ProductDTO productDTO = productService.updateProduct(request);
        ProductInfo productInfo = new ProductInfo(productDTO);
        return ResponseEntity.ok(new CommonResponse<>(productInfo));
    }

    @DeleteMapping(value = "v1/product/delete/{productId}")
    public ResponseEntity<?> deleteById(@PathVariable("productId") String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
