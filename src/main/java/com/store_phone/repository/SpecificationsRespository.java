package com.store_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.SpecificationEntity;

public interface SpecificationsRespository extends JpaRepository<SpecificationEntity, String> {

}
