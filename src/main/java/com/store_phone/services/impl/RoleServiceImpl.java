package com.store_phone.services.impl;

import com.store_phone.converters.RoleConverter;
import com.store_phone.dtos.RoleDTO;
import com.store_phone.entities.RoleEntity;
import com.store_phone.repositories.RoleRepository;
import com.store_phone.resquest.role.AddRoleRequest;
import com.store_phone.resquest.role.UpdateRoleRequest;
import com.store_phone.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDTO> findAll() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        return roleEntityList.stream().map(role ->
                roleConverter.converToDTO(role)).toList();
    }

    @Override
    public RoleDTO addRole(AddRoleRequest request) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(UUID.randomUUID().toString());
        roleEntity.setRoleName(request.getRoleName());
        roleEntity.setRoleDescription(request.getRoleDescription());
        roleRepository.save(roleEntity);
        return roleConverter.converToDTO(roleEntity);
    }

    @Override
    public RoleDTO findById(String roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElse(null);
        return roleConverter.converToDTO(roleEntity);
    }

    @Override
    public void deleteById(String roleId) {
       roleRepository.deleteById(roleId);
    }

    @Override
    public RoleDTO updateRole(UpdateRoleRequest request) {
        RoleEntity roleEntity = roleRepository.findById(request.getRoleId()).orElse(null);
        if (roleEntity == null) {
            return null;
        }
        roleEntity.setRoleName(request.getRoleName());
        roleEntity.setRoleDescription(request.getRoleDescription());
        roleRepository.save(roleEntity);
        return roleConverter.converToDTO(roleEntity);
    }

    @Override
    public List<RoleDTO> getRolesByRoleIdIn(Set<String> roles) {
        List<RoleEntity> roleEntities = roleRepository.findByRoleIdIn(roles);
        return roleEntities.stream().map(role -> roleConverter.converToDTO(role)).toList();
    }

    @Override
    public void save(RoleDTO roleDTO) {
        roleRepository.save(roleConverter.convertToEntity(roleDTO));
    }
}
