package com.store_phone.service;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.UserDTO;
import com.store_phone.request.user.AddUserRequest;
import com.store_phone.request.user.UpdateUserRequest;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.user.UserInfo;

public interface UserService {

	ResultDataPaging<UserInfo> findAll(Pageable pageable);
	
	UserDTO addUser(AddUserRequest request);
	
	UserDTO getInfoUser(String userName);
	
	UserDTO updateUser(UpdateUserRequest request);
	
	void deleteUser(String userName);
	
	UserDTO findByUserName(String userName);
}
