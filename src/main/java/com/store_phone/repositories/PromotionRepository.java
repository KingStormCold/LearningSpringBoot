package com.store_phone.repositories;

import com.store_phone.entities.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity, String> {
}
