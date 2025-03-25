package com.store_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
