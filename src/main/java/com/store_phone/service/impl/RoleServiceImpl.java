package com.store_phone.service.impl;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store_phone.converter.RoleConverter;
import com.store_phone.dto.RoleDTO;
import com.store_phone.entity.RoleEntity;
import com.store_phone.repository.RoleRepository;
import com.store_phone.request.role.AddRoleRequest;
import com.store_phone.request.role.UpdateRoleRequest;
import com.store_phone.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleEntity> roles = roleRepository.findAll();
		return roles.stream().map(role -> roleConverter.convertToDto(role)).toList();
	}

	@Override
	public RoleDTO addRole(AddRoleRequest request) {
		RoleEntity entity = new RoleEntity();
		entity.setRoleId(UUID.randomUUID().toString());
		entity.setRoleName(request.getRoleName());
		entity.setRoleDescription(request.getRoleDesciption());
		roleRepository.save(entity);
		return roleConverter.convertToDto(entity);
	}

	@Override
	public RoleDTO getRoleById(String roleId) {
		RoleEntity entity = roleRepository.findById(roleId).orElse(null);
		return roleConverter.convertToDto(entity);
	}

	@Override
	public void deleteRoleById(String roleId) {
		roleRepository.deleteById(roleId);
	}

	@Override
	public RoleDTO updateRole(UpdateRoleRequest request) {
		RoleEntity entity = roleRepository.findById(request.getRoleId()).orElse(null);
		if(entity == null) {
			return null;
		}
		entity.setRoleName(request.getRoleName());
		entity.setRoleDescription(request.getRoleDesciption());
		roleRepository.save(entity);
		return roleConverter.convertToDto(entity);
	}

	@Override
	public List<RoleDTO> getRolesByRoleIdIn(Set<String> roles) {
		//select * from role where role_id in (request.getRoles)
		List<RoleEntity> roleEntities = roleRepository.findByRoleIdIn(roles);
		return roleEntities.stream().map(role -> roleConverter.convertToDto(role)).toList();
	}

	@Override
	public void save(RoleDTO roleDTO) {
		roleRepository.save(roleConverter.convertToEntity(roleDTO));
	}
	
}
