package com.store_phone.repositories;

import com.store_phone.entities.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity, String> {
}
