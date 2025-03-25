package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.RoleDTO;
import com.store_phone.entity.RoleEntity;

@Component
public class RoleConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public RoleEntity convertToEntity(RoleDTO dto) {
        RoleEntity result = modelMapper.map(dto, RoleEntity.class);
        return result;
    }

    public RoleDTO convertToDto(RoleEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        RoleDTO result = modelMapper.map(entity, RoleDTO.class);
        return result;
    }

}
