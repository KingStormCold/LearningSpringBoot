package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.SpecificationDTO;
import com.store_phone.entity.SpecificationEntity;

@Component
public class SpecificationsConverter {
	
	@Autowired
    private ModelMapper modelMapper;
    
    public SpecificationEntity convertToEntity (SpecificationDTO dto) {
        SpecificationEntity result = modelMapper.map(dto, SpecificationEntity.class);
        return result;
    }
    
    public SpecificationDTO convertToDto(SpecificationEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        SpecificationDTO result = modelMapper.map(entity, SpecificationDTO.class);
        return result;
    }

}
