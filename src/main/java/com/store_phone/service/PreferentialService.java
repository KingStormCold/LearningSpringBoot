package com.store_phone.service;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.request.preference.AddPreferenceRequest;
import com.store_phone.request.preference.UpdatePreferenceRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preference.PreferenceInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PreferentialService {
    ResultDataPaging<PreferenceInfo> findAll (Pageable pageable);
    PreferentialDTO getPreferentialDetail(String preferentialId);
    PreferentialDTO findById(String preferentialId);
    PreferentialDTO addPreferential(AddPreferenceRequest request);
    PreferentialDTO updatePreferential(UpdatePreferenceRequest request);
    void deletePreferential(String preferentialId);

}
