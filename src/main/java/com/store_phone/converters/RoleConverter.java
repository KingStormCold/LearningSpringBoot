package com.store_phone.converters;

import com.store_phone.dtos.RoleDTO;
import com.store_phone.entities.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class RoleConverter {

    @Autowired
    private ModelMapper modelMapper;

    public RoleDTO converToDTO (RoleEntity roleEntity) {
        if (ObjectUtils.isEmpty(roleEntity)) {
            return null;
        }
        return modelMapper.map(roleEntity, RoleDTO.class);
    }

    public RoleEntity convertToEntity (RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, RoleEntity.class);
    }
}