package com.store_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store_phone.entity.ProductInfoEntity;

public interface ProductInfoRespository extends JpaRepository<ProductInfoEntity, String>{

}
