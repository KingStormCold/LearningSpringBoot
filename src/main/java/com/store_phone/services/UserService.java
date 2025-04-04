package com.store_phone.services;

import com.store_phone.dtos.UserDTO;
import com.store_phone.entities.UserEntity;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.user.UserInfo;
import com.store_phone.resquest.user.AddUserRequest;
import com.store_phone.resquest.user.UpdateUserRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    ResultDataPaging<UserInfo> findAll(Pageable pageable);
    UserDTO addUser(AddUserRequest request);
    UserDTO findByUserName(String userName);
    UserDTO getUserInfo(String userName);
    UserDTO updateUser(UpdateUserRequest request);
    void deleteUser(String userName);
}
