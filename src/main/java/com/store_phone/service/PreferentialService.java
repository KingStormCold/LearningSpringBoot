package com.store_phone.service;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.request.preferential.AddPreferentialRequest;
import com.store_phone.request.preferential.UpdatePreferentialRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.Preferential_info;
import org.springframework.data.domain.Pageable;

public interface PreferentialService {
    ResultDataPaging<Preferential_info> findAll (Pageable pageable);
    PreferentialDTO getPreferentialDetail(String preferentialId);
    PreferentialDTO findById(String preferentialId);
    PreferentialDTO addPreferential(AddPreferentialRequest request);
    PreferentialDTO updatePreferential(UpdatePreferentialRequest request);
    void deletePreferential(String preferentialId);

}
