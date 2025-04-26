package com.store_phone.service;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.request.preferential.AddPreferentialRequest;
import com.store_phone.request.preferential.UpdatePreferentialRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.PreferenceInfo;


public interface PreferentialService {
	
	PreferentialDTO addPreferential (AddPreferentialRequest request);
	
	ResultDataPaging<PreferenceInfo> findAllByPagination(Pageable pageable);
	
	PreferentialDTO getByPreferentialId(String preferentialId);
	
	PreferentialDTO updatePreferential(UpdatePreferentialRequest request);
	
	void deletePreferentialId(String preferentialId);

}
