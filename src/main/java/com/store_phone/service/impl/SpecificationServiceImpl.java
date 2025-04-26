package com.store_phone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.common.Constants;
import com.store_phone.converter.SpecificationsConverter;
import com.store_phone.dto.PreferentialDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.entity.PreferentialEntity;
import com.store_phone.entity.ProductEntity;
import com.store_phone.entity.SpecificationEntity;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.SpecificationsRespository;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.PreferenceInfo;
import com.store_phone.response.product.ProductDetail;
import com.store_phone.response.specification.SpecificationInfo;
import com.store_phone.service.ProductService;
import com.store_phone.service.SpecificationService;
import com.store_phone.utils.SecurityUtils;

@Service
public class SpecificationServiceImpl implements SpecificationService{
	
	@Autowired
	private SpecificationsConverter specificationsConverter;
	
	@Autowired
	private SpecificationsRespository specificationsRespository;

	
	@Override
	public SpecificationDTO addSpecification(AddSpecificationRequest request) {
		SpecificationDTO specificationDTO = new SpecificationDTO();
		specificationDTO.setSpecificationsId(UUID.randomUUID().toString());
		specificationDTO.setSpecificationsContent(request.getContent());
		specificationDTO.setCreatedBy(SecurityUtils.getCurrentUserLogin());
		specificationDTO.setProduct_id(request.getProduct_id());

		specificationsRespository.save(specificationsConverter.convertToEntity(specificationDTO));

		return specificationDTO;
	}

	@Override
	public ResultDataPaging<SpecificationInfo> findAllByPagination(Pageable pageable) {
		Page<SpecificationEntity> pageSpecifications = specificationsRespository.findAll(pageable);
		List<SpecificationDTO> specificationDTOs = pageSpecifications.getContent().stream()
				.map(specificationEntity -> specificationsConverter.convertToDto(specificationEntity)).toList();
				
		
		Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pageSpecifications.getTotalPages());
		List<SpecificationInfo> result = specificationDTOs.stream()
				.map(specificationDTO -> new SpecificationInfo(specificationDTO)).toList();
		
		return new ResultDataPaging<SpecificationInfo>(result, pagination);
	    }
	
	@Override
	public SpecificationDTO getBySpecificationId(String specificationId) {
		SpecificationEntity specificationEntity = specificationsRespository.findById(specificationId).orElse(null);
		return specificationsConverter.convertToDto(specificationEntity);
	}

	@Override
	public SpecificationDTO updateSpecification(UpdateSpecificationRequest request) {
		SpecificationDTO specificationDTO = getBySpecificationId(request.getSpecificationId());
		if (specificationDTO == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy Preferential");
		}
		specificationDTO.setSpecificationsContent(request.getContent());
		specificationDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
		specificationDTO.setProduct_id(request.getProduct_id());
		
		SpecificationEntity specificationEntity = specificationsConverter.convertToEntity(specificationDTO);
		specificationsRespository.save(specificationEntity);
		return specificationsConverter.convertToDto(specificationEntity);
	}

	@Override
	public void deleteSpecificationId(String specificationId) {
		if (specificationId == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy Preferential Id");
		}
		specificationsRespository.deleteById(specificationId);
		
	}

}
