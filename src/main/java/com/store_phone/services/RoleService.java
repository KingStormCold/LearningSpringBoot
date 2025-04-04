package com.store_phone.services;

import com.store_phone.dtos.RoleDTO;
import com.store_phone.resquest.role.AddRoleRequest;
import com.store_phone.resquest.role.UpdateRoleRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<RoleDTO> findAll();
    RoleDTO addRole(AddRoleRequest request);
    RoleDTO findById(String roleId);
    void deleteById(String roleId);
    RoleDTO updateRole(UpdateRoleRequest request);
    List<RoleDTO> getRolesByRoleIdIn(Set<String> roles);
    void save(RoleDTO roleDTO);
}
