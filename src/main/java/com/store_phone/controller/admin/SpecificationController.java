package com.store_phone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store_phone.dto.SpecificationDTO;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.specification.SpecificationInfo;
import com.store_phone.service.SpecificationService;

import jakarta.validation.Valid;

@RestController
public class SpecificationController {

	@Autowired
	private SpecificationService specificationService;
	
	 @GetMapping("v1/specifications")
	    public ResponseEntity<CommonResponse<ResultDataPaging<SpecificationInfo>>> findAllByPagination (Pageable pageable) {
	        return ResponseEntity.ok(new CommonResponse<>(specificationService.findAllByPagination(pageable)));
	    }
	
	  @PostMapping(value = "v1/specification")
	    public ResponseEntity<CommonResponse<SpecificationDTO>> addPreferential (@Valid @RequestBody AddSpecificationRequest request) {
	        return ResponseEntity.ok(new CommonResponse<>(specificationService.addSpecification(request)));
	    }
	  
	   @GetMapping("v1/specification/{id}")
	    public ResponseEntity<CommonResponse<SpecificationInfo>> getByPreferentialId (@PathVariable("id") String specificationId) {
	        SpecificationDTO specificationDTO = specificationService.getBySpecificationId(specificationId);
	        SpecificationInfo specificationInfo = new SpecificationInfo(specificationDTO);
	        return ResponseEntity.ok(new CommonResponse<>(specificationInfo));
	    }

	    @PutMapping(value = "v1/specification")
	    public ResponseEntity<CommonResponse<SpecificationInfo>> updateSpecification (@Valid @RequestBody UpdateSpecificationRequest request) {
	    	SpecificationDTO specificationDTO = specificationService.updateSpecification(request);
	        SpecificationInfo specificationInfo = new SpecificationInfo(specificationDTO);
	        return ResponseEntity.ok(new CommonResponse<>(specificationInfo));
	    }

	    @DeleteMapping(value = "v1/specification/{Id}")
	    public ResponseEntity<?> deleteById (@PathVariable("Id") String specificationId) {
	    	specificationService.deleteSpecificationId(specificationId);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }

}
