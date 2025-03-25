package com.store_phone.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.store_phone.dto.UserDTO;
import com.store_phone.entity.UserEntity;

@Component
public class UserConverter {
	
	@Autowired
    private ModelMapper modelMapper;

    public UserEntity convertToEntity(UserDTO dto) {
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }

    public UserDTO convertToDto(UserEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

}
