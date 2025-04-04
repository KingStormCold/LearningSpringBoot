package com.store_phone.repositories;

import com.store_phone.entities.SpecificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationsRepository extends JpaRepository<SpecificationEntity, String> {
}
