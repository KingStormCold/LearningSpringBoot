package com.store_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.CategoryEntity;

public interface CategoryRespository extends JpaRepository<CategoryEntity, String>{

}
