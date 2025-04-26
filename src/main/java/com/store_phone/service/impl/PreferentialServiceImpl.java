package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.PreferentialConverter;
import com.store_phone.dto.PreferentialDTO;
import com.store_phone.dto.ProductDTO;
import com.store_phone.entity.PreferentialEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.PreferentialRespository;
import com.store_phone.request.preferential.AddPreferentialRequest;
import com.store_phone.request.preferential.UpdatePreferentialRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.preferential.Preferential_info;
import com.store_phone.service.ProductService;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.PreferentialService;
import org.springframework.util.ObjectUtils;

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
    public ResultDataPaging<Preferential_info> findAll(Pageable pageable) {
        Page<PreferentialEntity> pagePreferential = preferentialRespository.findAll(pageable);

        List<PreferentialDTO> preferentialDTOS = pagePreferential.getContent().stream()
                .map(preferentialEntity -> preferentialConverter.convertToDto(preferentialEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pagePreferential.getTotalPages());
        List<Preferential_info> result = preferentialDTOS.stream().map(preferentialDTO -> new Preferential_info(preferentialDTO)).toList();

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
    public PreferentialDTO addPreferential(AddPreferentialRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this product to create new Preferential");
        }

        PreferentialDTO newPreferential = new PreferentialDTO();

        newPreferential.setPreferentialId(UUID.randomUUID().toString());
        newPreferential.setContent(request.getContent());
        newPreferential.setCreatedBy(SecurityUtils.getCurrentUserLogin());
        newPreferential.setProductDTO(productDTO);

        preferentialRespository.save(preferentialConverter.convertToEntity(newPreferential));

        return newPreferential;
    }

    @Override
    public PreferentialDTO updatePreferential(UpdatePreferentialRequest request) {
        ProductDTO productDTO = productService.getProductInfo(request.getProductId());
        if (productDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this product to update this Preferential");
        }

        PreferentialDTO preferentialDTO = findById(request.getPreferentialId());
        if (preferentialDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this Preferential");
        }

        preferentialDTO.setContent(request.getContent());
        preferentialDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
        preferentialDTO.setProductDTO(productDTO);

        PreferentialEntity preferentialEntity = preferentialConverter.convertToEntity(preferentialDTO);
        preferentialRespository.save(preferentialEntity);

        return preferentialConverter.convertToDto(preferentialEntity);
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
