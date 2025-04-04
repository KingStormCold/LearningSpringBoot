package com.store_phone.converters;

import com.store_phone.dtos.UserDTO;
import com.store_phone.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO converToDTO (UserEntity userEntity) {
        if (ObjectUtils.isEmpty(userEntity)) {
            return null;
        }
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity converToEntity (UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
