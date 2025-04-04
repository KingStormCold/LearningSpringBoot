package com.store_phone.repositories;

import com.store_phone.entities.PreferentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Preferential extends JpaRepository<PreferentialEntity, String> {
}
