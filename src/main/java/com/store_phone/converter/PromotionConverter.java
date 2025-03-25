package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.PromotionDTO;
import com.store_phone.entity.PromotionEntity;

@Component
public class PromotionConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public PromotionEntity convertToEntity(PromotionDTO dto) {
        PromotionEntity result = modelMapper.map(dto, PromotionEntity.class);
        return result;
    }

    public PromotionDTO convertToDto(PromotionEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        PromotionDTO result = modelMapper.map(entity, PromotionDTO.class);
        return result;
    }

}
