package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.PreferentialConverter;
import com.store_phone.dto.PreferentialDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.entity.PreferentialEntity;
import com.store_phone.entity.ProductEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.PreferentialRespository;
import com.store_phone.request.preference.AddPreferenceRequest;
import com.store_phone.request.preference.UpdatePreferenceRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preference.PreferenceInfo;
import com.store_phone.service.ProductService;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.PreferentialService;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PreferentialServiceImpl implements PreferentialService{

    @Autowired
    private PreferentialRespository preferentialRespository;

    @Autowired
    private PreferentialConverter preferentialConverter;

    @Autowired
    private ProductService productService;

    @Override
    public ResultDataPaging<PreferenceInfo> findAll(Pageable pageable) {
        Page<PreferentialEntity> pagePreferential = preferentialRespository.findAll(pageable);

        List<PreferentialDTO> preferentialDTOS = pagePreferential.getContent().stream()
                .map(preferentialEntity -> preferentialConverter.convertToDto(preferentialEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pagePreferential.getTotalPages());
        List<PreferenceInfo> result = preferentialDTOS.stream().map(preferentialDTO -> new PreferenceInfo(preferentialDTO)).toList();

        return new ResultDataPaging<>(result, pagination);
    }

    @Override
    public PreferentialDTO getPreferentialDetail(String preferentialId) {
        if (ObjectUtils.isEmpty(preferentialId)) {
            throw new BadRequestException(Constants.NOT_EMPTY, "PreferentialId");
        }
        PreferentialDTO preferentialDTO = findById(preferentialId);
        if (preferentialDTO == null) {
            throw new UnprocessableException(Constants.NOT_EMPTY,"Cannot find this Preferential");
        }
        return preferentialDTO;
    }

    @Override
    public PreferentialDTO findById(String preferentialId) {
        PreferentialEntity preferentialEntity = preferentialRespository.findById(preferentialId).orElse(null);
        return preferentialConverter.convertToDto(preferentialEntity);
    }

    @Override
    public PreferenceInfo addPreferential(AddPreferenceRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find this product to create Preferential");
        }

        PreferentialDTO newPreferential = new PreferentialDTO();

        newPreferential.setPreferentialId(UUID.randomUUID().toString());
        newPreferential.setContent(request.getContent());
        newPreferential.setCreatedBy(SecurityUtils.getCurrentUserLogin());
        newPreferential.setCreatedDate(LocalDateTime.now());
        newPreferential.setProduct(productDTO);

        PreferentialEntity preferentialEntity = preferentialConverter.convertToEntity(newPreferential);
        preferentialRespository.save(preferentialEntity);

        PreferentialDTO preferentialDTO = preferentialConverter.convertToDto(preferentialEntity);

        return new PreferenceInfo(preferentialDTO);
    }

    @Override
    public PreferenceInfo updatePreferential(UpdatePreferenceRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Product");
        }

        PreferentialDTO preferentialDTO = findById(request.getPreferentialId());
        if (preferentialDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Preferential");
        }

        preferentialDTO.setContent(request.getContent());
        preferentialDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
        preferentialDTO.setProduct(productDTO);
        preferentialDTO.setUpdatedDate(LocalDateTime.now());

        PreferentialEntity preferentialEntity = preferentialConverter.convertToEntity(preferentialDTO);
        preferentialRespository.save(preferentialEntity);

        return new PreferenceInfo(preferentialConverter.convertToDto(preferentialEntity ));
    }

    @Override
    public void deletePreferential(String preferentialId) {
        PreferentialDTO preferentialDTO = findById(preferentialId);
        if (preferentialDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Preferential to delete");
        }
        preferentialRespository.deleteById(preferentialId);
    }
}
