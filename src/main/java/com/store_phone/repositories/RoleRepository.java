package com.store_phone.repositories;

import com.store_phone.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    List<RoleEntity> findByRoleIdIn(Set<String> roles);
}
