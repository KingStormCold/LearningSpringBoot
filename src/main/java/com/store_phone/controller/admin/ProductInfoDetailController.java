package com.store_phone.controller.admin;

import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info_detail.AddProductInfoDetail;
import com.store_phone.request.product_info_detail.UpdateProductInfoDetail;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info_detail.ProductInfoDetailResponse;
import com.store_phone.service.ProductInfoDetailSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductInfoDetailController {

    @Autowired
    private ProductInfoDetailSerivce productInfoDetailSerivce;

    @GetMapping("v1/productInfoDetail/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<ProductInfoDetailResponse>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(productInfoDetailSerivce.findAll(pageable)));
    }

    @GetMapping("v1/productInfoDetail/{productInfoDetailId}")
    public ResponseEntity<CommonResponse<ProductInfoDetailResponse>> findById (@PathVariable("productInfoDetailId") String productInfoDetailId) {
        return ResponseEntity.ok(new CommonResponse<>(productInfoDetailSerivce.getProductInfoDetail(productInfoDetailId)));
    }

    @PostMapping("v1/productInfoDetail")
    public ResponseEntity<CommonResponse<ProductInfoDetailResponse>> addProductInfoDetail (@Valid @RequestBody AddProductInfoDetail request) {
        return ResponseEntity.ok(new CommonResponse<>(productInfoDetailSerivce.addProductInfoDetail(request)));
    }

    @PutMapping("v1/productInfoDetail")
    public ResponseEntity<CommonResponse<ProductInfoDetailResponse>> updateProductInfoDetail (@Valid @RequestBody UpdateProductInfoDetail request) {
        return ResponseEntity.ok(new CommonResponse<>(productInfoDetailSerivce.updateProductInfoDetail(request)));
    }

    @DeleteMapping("v1/productInfoDetail/{productInfoDetailId}")
    public ResponseEntity<?> deleteById (@PathVariable("productInfoDetailId") String productInfoDetailId) {
        productInfoDetailSerivce.deleteProductInfoDetail(productInfoDetailId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
