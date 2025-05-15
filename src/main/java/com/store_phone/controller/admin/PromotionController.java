package com.store_phone.controller.admin;

import com.store_phone.request.promotion.AddPromotionRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.promotion.PromotionResponse;
import com.store_phone.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "v1/promotion")
    public ResponseEntity<CommonResponse<PromotionResponse>> addPromotion (@Valid @RequestBody AddPromotionRequest request) {
        return null;
    }

    @DeleteMapping(value = "v1/promotion/{promotionId}")
    public ResponseEntity<CommonResponse<PromotionResponse>> deletePromotion (@PathVariable("promotionId") String promotionId) {
        promotionService.deletePromotion(promotionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
