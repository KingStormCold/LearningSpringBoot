package com.store_phone.services.impl;

import com.store_phone.common.Pagination;
import com.store_phone.converters.RoleConverter;
import com.store_phone.converters.UserConverter;
import com.store_phone.dtos.RoleDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.entities.RoleEntity;
import com.store_phone.entities.UserEntity;
import com.store_phone.exception.BadRequestException;
import com.store_phone.exception.UnprocessableException;
import com.store_phone.repositories.UserRepository;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.user.UserInfo;
import com.store_phone.resquest.user.AddUserRequest;
import com.store_phone.resquest.user.UpdateUserRequest;
import com.store_phone.security.JwtUtil;
import com.store_phone.services.RoleService;
import com.store_phone.services.UserService;
import com.store_phone.utils.PasswordUtils;
import com.store_phone.utils.SecurityUtils;
import common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleService roleService;


    @Override
    public ResultDataPaging<UserInfo> findAll(Pageable pageable) {
        Page<UserEntity> pageUsers = userRepository.findAll(pageable);
        //trả về values - list users
        List<UserDTO> users = pageUsers.getContent().stream()
                .map(userEntity -> userConverter.converToDTO(userEntity)).toList();
        //trả về pagination
        Pagination pagination = new Pagination(pageable.getPageNumber(), pageable.getPageSize(), pageUsers.getTotalPages());
        List<UserInfo> results = users.stream().map(user -> new UserInfo(user)).toList();
        return new ResultDataPaging<UserInfo>(results, pagination);
    }

    @Override
    public UserDTO addUser(AddUserRequest request) {
        UserDTO checkUser = findByUserName(request.getUserName());
        if (checkUser != null) {
            throw new UnprocessableException(Constants.EXISTED, "User existed");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(PasswordUtils.generatePassword(request.getPassword()));
        userDTO.setPassword(request.getPassword());
        userDTO.setAddress(request.getAddress());
        userDTO.setFullName(request.getFullName());
        userDTO.setPhoneNumber(request.getPhone());
        userDTO.setEmail(request.getEmail());
        userDTO.setActive(true);
        userDTO.setCreatedBy(SecurityUtils.getCurrentUserLogin());

        UserEntity userEntity = userConverter.converToEntity(userDTO);
        userRepository.save(userEntity);

        //thêm role cho user
        List<RoleDTO> roles = roleService.getRolesByRoleIdIn(request.getRoles());
        for (RoleDTO roleDTO : roles)  {
            roleDTO.getUsers().add(userDTO);
            roleService.save(roleDTO);
        }
        return userConverter.converToDTO(userEntity);
    }

    @Override
    public UserDTO getUserInfo(String userName) {
        if (ObjectUtils.isEmpty(userName)) {
            throw new BadRequestException(Constants.NOT_EMPTY, "username");
        }
        UserEntity userEntity = userRepository.findById(userName).orElse(null);
        if (userEntity == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Cannot find user");
        }
        return userConverter.converToDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UpdateUserRequest request) {
        UserDTO userDTO = findByUserName(request.getUserName());
        if(userDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy username");
        }
        userDTO.setFullName(request.getFullName());
        userDTO.setAddress(request.getAddress());
        userDTO.setPassword(PasswordUtils.generatePassword(request.getPassword()));
        userDTO.setPhoneNumber(request.getPhone());
        userDTO.setEmail(request.getEmail());
        userDTO.setActive(request.isActive());
        userDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());

        UserEntity userEntity = userConverter.converToEntity(userDTO);
        userRepository.save(userEntity);

        //1. lấy hết danh sách role
        List<RoleDTO> roles = roleService.findAll();

        //2. tạo ra 1 list remove role
        List<RoleDTO> addRoles = roleService.getRolesByRoleIdIn(request.getRoles());
        List<RoleDTO> removeRoles = new ArrayList<RoleDTO>(roles);
        removeRoles.removeAll(addRoles);

        //3. duyệt list remove role để xóa user có trong list remove role
        for(RoleDTO roleDTO: removeRoles) {
            roleDTO.getUsers().remove(userDTO);
            roleService.save(roleDTO);
        }
        //4. add danh sách role cho user
        for(RoleDTO roleDTO: addRoles) {
            roleDTO.getUsers().add(userDTO);
            roleService.save(roleDTO);
        }

        return userDTO;
    }

    @Override
    public void deleteUser(String userName) {
        UserDTO userDTO = findByUserName(userName);
        if(userDTO == null) {
            throw new UnprocessableException(Constants.NOT_FOUND, "Không tìm thấy username");
        }
        userDTO.setActive(false);
        userDTO.setUpdatedBy(SecurityUtils.getCurrentUserLogin());

        UserEntity userEntity = userConverter.converToEntity(userDTO);
        userRepository.save(userEntity);

        Set<String> roless = new HashSet<String>();
        for(RoleDTO roleDTO: userDTO.getRoles()) {
            roless.add(roleDTO.getRoleId());
        }

        List<RoleDTO> roles = roleService.getRolesByRoleIdIn(roless);
        for(RoleDTO roleDTO: roles) {
            roleDTO.getUsers().remove(userDTO);
            roleService.save(roleDTO);
        }
    }

    @Override
    public UserDTO findByUserName(String userName) {
        UserEntity userEntity = userRepository.findById(userName).orElse(null);
        return userConverter.converToDTO(userEntity);
    }
}
