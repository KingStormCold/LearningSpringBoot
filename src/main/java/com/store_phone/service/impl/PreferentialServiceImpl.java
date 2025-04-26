package com.store_phone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.common.Constants;
import com.store_phone.converter.PreferentialConverter;
import com.store_phone.dto.PreferentialDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.entity.PreferentialEntity;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.PreferentialRespository;
import com.store_phone.request.preferential.AddPreferentialRequest;
import com.store_phone.request.preferential.UpdatePreferentialRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.PreferenceInfo;
import com.store_phone.service.PreferentialService;
import com.store_phone.service.ProductService;
import com.store_phone.utils.SecurityUtils;

@Service
public class PreferentialServiceImpl implements PreferentialService {

	@Autowired
	private PreferentialRespository preferentialRespository;

	@Autowired
	private PreferentialConverter preferentialConverter;

	@Autowired
	private ProductService productService;

	@Override
	public PreferentialDTO addPreferential(AddPreferentialRequest request) {
		PreferentialDTO newPreferential = new PreferentialDTO();

		newPreferential.setPreferentialId(UUID.randomUUID().toString());
		newPreferential.setContent(request.getContent());
		newPreferential.setCreatedBy(SecurityUtils.getCurrentUserLogin());
		newPreferential.setProduct_id(request.getProduct_id());

		preferentialRespository.save(preferentialConverter.convertToEntity(newPreferential));

		return newPreferential;
	}

	@Override
	public ResultDataPaging<PreferenceInfo> findAllByPagination(Pageable pageable) {
		Page<PreferentialEntity> pagePreferentials = preferentialRespository.findAll(pageable);

		List<PreferentialDTO> preferentialDTOS = pagePreferentials.getContent().stream()
				.map(preferentialEntity -> preferentialConverter.convertToDto(preferentialEntity)).toList();

		Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(),
				pagePreferentials.getTotalPages());
		List<PreferenceInfo> result = preferentialDTOS.stream()
				.map(preferentialDTO -> new PreferenceInfo(preferentialDTO)).toList();

		return new ResultDataPaging<>(result, pagination);
	}

	@Override
	public PreferentialDTO getByPreferentialId(String preferentialId) {
		PreferentialEntity preferentialEntity = preferentialRespository.findById(preferentialId).orElse(null);
		return preferentialConverter.convertToDto(preferentialEntity);
	}

	@Override
	public PreferentialDTO updatePreferential(UpdatePreferentialRequest request) {
		PreferentialDTO preferentialDTO = getByPreferentialId(request.getPreferentialId());
		if (preferentialDTO == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy Preferential");
		}

		preferentialDTO.setContent(request.getContent());
		preferentialDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
		preferentialDTO.setProduct_id(request.getProduct_id());

		PreferentialEntity preferentialEntity = preferentialConverter.convertToEntity(preferentialDTO);
		preferentialRespository.save(preferentialEntity);

		return preferentialConverter.convertToDto(preferentialEntity);
	}

	@Override
	public void deletePreferentialId(String preferentialId) {
		if (preferentialId == null) {
			throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy Preferential Id");
		}
		preferentialRespository.deleteById(preferentialId);
	}

}
