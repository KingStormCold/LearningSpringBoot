package com.store_phone.service;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.request.category.UpdateCategoryRequest;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.response.specification.SpecificationResponse;
import org.springframework.data.domain.Pageable;

public interface SpecificationService {
    ResultDataPaging<SpecificationResponse> findAll (Pageable pageable);
    SpecificationDTO getSpecificationDetail(String specificationId);
    SpecificationDTO findById(String specificationId);
    SpecificationResponse addSpecification(AddSpecificationRequest request);
    SpecificationResponse updateSpecification(UpdateSpecificationRequest request);
    void deleteSpecification(String specificationId);
}
