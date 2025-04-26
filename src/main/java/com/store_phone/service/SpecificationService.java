package com.store_phone.service;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.specification.SpecificationInfo;

public interface SpecificationService {

	
	SpecificationDTO addSpecification(AddSpecificationRequest request);

	ResultDataPaging<SpecificationInfo> findAllByPagination(Pageable pageable);

	SpecificationDTO getBySpecificationId(String specificationId);

	SpecificationDTO updateSpecification(UpdateSpecificationRequest request);

	void deleteSpecificationId(String specificationId);
}
