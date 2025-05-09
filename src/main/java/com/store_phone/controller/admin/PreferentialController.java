package com.store_phone.controller.admin;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.request.preference.AddPreferenceRequest;
import com.store_phone.request.preference.UpdatePreferenceRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preference.PreferenceInfo;
import com.store_phone.service.PreferentialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreferentialController {

    @Autowired
    private PreferentialService preferentialService;

    @GetMapping("v1/preferential/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<PreferenceInfo>>> findAll (Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(preferentialService.findAll(pageable)));
    }

    @GetMapping("v1/preferential/{preferentialId}")
    public ResponseEntity<CommonResponse<PreferenceInfo>> findById (@PathVariable("preferentialId") String preferentialId) {
        PreferentialDTO preferentialDTO = preferentialService.findById(preferentialId);
        PreferenceInfo preferenceInfo = new PreferenceInfo(preferentialDTO);
        return ResponseEntity.ok(new CommonResponse<>(preferenceInfo));
    }

    @PostMapping(value = "v1/preferential")
    public ResponseEntity<CommonResponse<PreferenceInfo>> addPreferential (@Valid @RequestBody AddPreferenceRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(preferentialService.addPreferential(request)));
    }

    @PutMapping(value = "v1/preferential")
    public ResponseEntity<CommonResponse<PreferenceInfo>> updatePreferential (@Valid @RequestBody UpdatePreferenceRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(preferentialService.updatePreferential(request)));
    }

    @DeleteMapping(value = "v1/preferential/{preferentialId}")
    public ResponseEntity<?> deleteById (@PathVariable("preferentialId") String preferentialId) {
        preferentialService.deletePreferential(preferentialId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
