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

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.request.preferential.AddPreferentialRequest;
import com.store_phone.request.preferential.UpdatePreferentialRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.PreferenceInfo;
import com.store_phone.service.PreferentialService;

import jakarta.validation.Valid;

@RestController

public class PreferentialController {
	@Autowired
	private PreferentialService preferentialService;
	
	  @GetMapping("v1/preferences")
	    public ResponseEntity<CommonResponse<ResultDataPaging<PreferenceInfo>>> findAllByPagination (Pageable pageable) {
	        return ResponseEntity.ok(new CommonResponse<>(preferentialService.findAllByPagination(pageable)));
	    }
	
	  @PostMapping(value = "v1/preferential")
	    public ResponseEntity<CommonResponse<PreferentialDTO>> addPreferential (@Valid @RequestBody AddPreferentialRequest request) {
	        return ResponseEntity.ok(new CommonResponse<>(preferentialService.addPreferential(request)));
	    }
	  
	   @GetMapping("v1/preferential/{preferentialId}")
	    public ResponseEntity<CommonResponse<PreferenceInfo>> getByPreferentialId (@PathVariable("preferentialId") String preferentialId) {
	        PreferentialDTO preferentialDTO = preferentialService.getByPreferentialId(preferentialId);
	        PreferenceInfo preferenceInfo = new PreferenceInfo(preferentialDTO);
	        return ResponseEntity.ok(new CommonResponse<>(preferenceInfo));
	    }

	    @PutMapping(value = "v1/preferential")
	    public ResponseEntity<CommonResponse<PreferenceInfo>> updatePreferential (@Valid @RequestBody UpdatePreferentialRequest request) {
	        PreferentialDTO preferentialDTO = preferentialService.updatePreferential(request);
	        PreferenceInfo preferenceInfo = new PreferenceInfo(preferentialDTO);
	        return ResponseEntity.ok(new CommonResponse<>(preferenceInfo));
	    }

	    @DeleteMapping(value = "v1/preferential/{Id}")
	    public ResponseEntity<?> deleteById (@PathVariable("Id") String preferentialId) {
	        preferentialService.deletePreferentialId(preferentialId);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }


}
