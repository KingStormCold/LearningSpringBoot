package com.store_phone.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String>{
	//select * from role where role_id in (request.getRoles)
	List<RoleEntity> findByRoleIdIn(Set<String> roles);
}
