package com.store_phone.controllers.admin;

import com.store_phone.dtos.ProductInfoDetailDTO;
import com.store_phone.services.ProductInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductInfoDetailController {

    @Autowired
    private ProductInfoDetailService productInfoDetailService;

    @GetMapping(value = "v1/product-info-detail")
    public List<ProductInfoDetailDTO> findAll() {
        return productInfoDetailService.findAll();
    }


}
