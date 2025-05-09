package com.store_phone.controller.admin;

import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.promotion.PromotionResponse;
import com.store_phone.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping(value = "v1/promotion")
    public ResponseEntity<CommonResponse<ResultDataPaging<PromotionResponse>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(promotionService.findAll(pageable)));
    }

    @GetMapping(value = "v1/promotion/{promotionId}")
    public ResponseEntity<CommonResponse<PromotionResponse>> findById (@PathVariable("promotionId") String promotionId) {
        return ResponseEntity.ok(new CommonResponse<>(promotionService.getPromotionInfo(promotionId)));
    }

}
