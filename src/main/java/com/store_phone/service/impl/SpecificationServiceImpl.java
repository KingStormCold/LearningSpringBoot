package com.store_phone.service.impl;

import com.store_phone.common.Constants;
import com.store_phone.converter.SpecificationsConverter;
import com.store_phone.dto.CategoryDTO;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.entity.CategoryEntity;
import com.store_phone.entity.SpecificationEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repository.SpecificationsRespository;
import com.store_phone.request.specification.AddSpecificationRequest;
import com.store_phone.request.specification.UpdateSpecificationRequest;
import com.store_phone.response.Pagination;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.specification.SpecificationResponse;
import com.store_phone.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store_phone.service.SpecificationService;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class SpecificationServiceImpl implements SpecificationService{

    @Autowired
    private SpecificationsRespository specificationsRespository;

    @Autowired
    private SpecificationsConverter specificationsConverter;

    @Override
    public ResultDataPaging<SpecificationResponse> findAll(Pageable pageable) {
        Page<SpecificationEntity> pageSpecifications = specificationsRespository.findAll(pageable);

        List<SpecificationDTO> specificationDTOS = pageSpecifications.getContent().stream()
                .map(specificationEntity -> specificationsConverter.convertToDto(specificationEntity)).toList();

        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(),pageSpecifications.getTotalPages());
        List<SpecificationResponse> result = specificationDTOS.stream().map(specificationDTO -> new SpecificationResponse(specificationDTO)).toList();

        return new ResultDataPaging<>(result, pagination);
    }

    @Override
    public SpecificationDTO getSpecificationDetail(String specificationId) {
        if (ObjectUtils.isEmpty(specificationId)) {
            throw new BadRequestException(Constants.NOT_FOUND,"specificationId");
        }
        SpecificationDTO specificationDTO = findById(specificationId);
        if (specificationDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this specification!");
        }
        return specificationDTO;
    }

    @Override
    public SpecificationDTO findById(String specificationId) {
        SpecificationEntity specificationEntity = specificationsRespository.findById(specificationId).orElse(null);
        return specificationsConverter.convertToDto(specificationEntity);
    }

    @Override
    public SpecificationDTO addSpecification(AddSpecificationRequest request) {
        SpecificationDTO newSpecification = new SpecificationDTO();
        newSpecification.setSpecificationsId(UUID.randomUUID().toString());
        newSpecification.setSpecificationsContent(request.getSpecificationsContent());
        newSpecification.setCreatedBy(SecurityUtils.getCurrentUserLogin());

        specificationsRespository.save(specificationsConverter.convertToEntity(newSpecification));
        return newSpecification;
    }

    @Override
    public SpecificationDTO updateSpecification(UpdateSpecificationRequest request) {
        SpecificationDTO specificationDTO = findById(request.getSpecificationId());
        if (specificationDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this specification");
        }
        specificationDTO.setSpecificationsContent(request.getSpecificationsContent());
        specificationDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());

        SpecificationEntity specificationEntity = specificationsConverter.convertToEntity(specificationDTO);
        specificationsRespository.save(specificationEntity);

        return specificationDTO;
    }

    @Override
    public void deleteSpecification(String specificationId) {
        SpecificationDTO specificationDTO = findById(specificationId);
        if (specificationDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND,"Cannot find this category!");
        }
        specificationsRespository.deleteById(specificationId);
    }
}
