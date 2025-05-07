package com.store_phone.controller.admin;

import com.store_phone.dto.ProductDTO;
import com.store_phone.request.product.AddProductRequest;
import com.store_phone.request.product.UpdateProductRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product.ProductInfo;
import com.store_phone.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("v1/product/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<ProductInfo>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(productService.findAll(pageable)));
    }

    @GetMapping("v1/product/{productId}")
    public ResponseEntity<CommonResponse<ProductInfo>> findById (@PathVariable("productId") String productId) {
        ProductDTO productDTO = productService.getProductInfo(productId);
        ProductInfo productInfo = new ProductInfo(productDTO);
        return ResponseEntity.ok(new CommonResponse<>(productInfo));
    }

    @PostMapping(value = "v1/product")
    public ResponseEntity<CommonResponse<ProductInfo>> addProduct (@Valid @RequestBody AddProductRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(productService.addProduct(request)));
    }

    @PutMapping(value = "v1/product")
    public ResponseEntity<CommonResponse<ProductInfo>> updateProduct (@Valid @RequestBody UpdateProductRequest request) {
        ProductDTO productDTO = productService.updateProduct(request);
        ProductInfo productInfo = new ProductInfo(productDTO);
        return ResponseEntity.ok(new CommonResponse<>(productInfo));
    }

    @DeleteMapping(value = "v1/product/{productId}")
    public ResponseEntity<?> deleteById (@PathVariable("productId") String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
