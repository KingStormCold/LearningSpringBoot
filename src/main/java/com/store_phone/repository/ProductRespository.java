package com.store_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.ProductEntity;

public interface ProductRespository extends JpaRepository<ProductEntity, String>{

}
