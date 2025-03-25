package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.PreferentialDTO;
import com.store_phone.entity.PreferentialEntity;

@Component
public class PreferentialConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public PreferentialEntity convertToEntity(PreferentialDTO dto) {
        PreferentialEntity result = modelMapper.map(dto, PreferentialEntity.class);
        return result;
    }

    public PreferentialDTO convertToDto(PreferentialEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        PreferentialDTO result = modelMapper.map(entity, PreferentialDTO.class);
        return result;
    }
}
