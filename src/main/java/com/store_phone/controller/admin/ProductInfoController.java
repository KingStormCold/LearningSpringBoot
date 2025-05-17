package com.store_phone.controller.admin;

import com.store_phone.dto.ProductInfoDTO;
import com.store_phone.request.product_info.AddProductInfoRequest;
import com.store_phone.request.product_info.UpdateProductInfoRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.product_info.ProductInfoResponse;
import com.store_phone.service.ProductInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("v1/productInfo/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<ProductInfoResponse>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(productInfoService.findAll(pageable)));
    }

    @GetMapping("v1/productInfo/{productInfoId}")
    public ResponseEntity<CommonResponse<ProductInfoResponse>> findById (@PathVariable("productInfoId") String productInfoId) {
        ProductInfoDTO productInfoDTO = productInfoService.getProductInfo(productInfoId);
        ProductInfoResponse productInfoResponse = new ProductInfoResponse(productInfoDTO);
        return ResponseEntity.ok(new CommonResponse<>(productInfoResponse));
    }

    @PostMapping("v1/productInfo")
    public ResponseEntity<CommonResponse<ProductInfoResponse>> addProductInfo (@Valid @RequestBody AddProductInfoRequest request)  {
        return ResponseEntity.ok(new CommonResponse<>(productInfoService.addProductInfo(request)));
    }

    @PutMapping("v1/productInfo")
    public ResponseEntity<CommonResponse<ProductInfoResponse>> updateProductInfo (@Valid @RequestBody UpdateProductInfoRequest request)  {
        return ResponseEntity.ok(new CommonResponse<>(productInfoService.updateProductInfo(request)));
    }

    @DeleteMapping("v1/preferential/{productInfoId}")
    public ResponseEntity<?> deleteById (@PathVariable("productInfoId") String productInfoId) {
        productInfoService.deleteProductInfo(productInfoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
