package com.store_phone.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.store_phone.dto.RoleDTO;
import com.store_phone.request.role.AddRoleRequest;
import com.store_phone.request.role.UpdateRoleRequest;

public interface RoleService {
	
	List<RoleDTO> findAll();
	RoleDTO getRoleById(String roleId);
	RoleDTO addRole(AddRoleRequest request);
	RoleDTO updateRole(UpdateRoleRequest request);
	void deleteRoleById(String roleId);
	
	List<RoleDTO> getRolesByRoleIdIn(Set<String> roles);
	void save(RoleDTO roleDTO);
}
