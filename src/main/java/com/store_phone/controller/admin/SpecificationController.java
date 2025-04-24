package com.store_phone.controller.admin;

import com.store_phone.dto.SpecificationDTO;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.specification.SpecificationResponse;
import com.store_phone.service.SpecificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping(value = "v1/specification/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<SpecificationResponse>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(specificationService.findAll(pageable)));
    }

    @GetMapping(value = "v1/specification/{specificationId}")
    public ResponseEntity<CommonResponse<SpecificationResponse>> findById(@PathVariable("specificationId") String specificationId) {
        SpecificationDTO specificationDTO = specificationService.getSpecificationDetail(specificationId);
        SpecificationResponse specificationResponse = new SpecificationResponse(specificationDTO);
        return ResponseEntity.ok(new CommonResponse<>(specificationResponse));
    }

    @PostMapping(value = "v1/specification")
    public ResponseEntity<CommonResponse<SpecificationDTO>> addSpecification (@Valid @RequestBody AddSpecificationRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(specificationService.addSpecification(request)));
    }

    @PutMapping(value = "v1/specification")
    public ResponseEntity<CommonResponse<SpecificationResponse>> updateSpecification (@Valid @RequestBody UpdateSpecificationRequest request) {
        SpecificationDTO specificationDTO = specificationService.updateSpecification(request);
        SpecificationResponse specificationResponse = new SpecificationResponse(specificationDTO);
        return ResponseEntity.ok(new CommonResponse<>(specificationResponse));
    }

    @DeleteMapping(value = "v1/specification/{specificationId}")
    public ResponseEntity<?> deleteById (@PathVariable("specificationId") String specificationId) {
        specificationService.deleteSpecification(specificationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
