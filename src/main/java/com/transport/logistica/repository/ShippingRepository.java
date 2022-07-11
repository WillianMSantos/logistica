package com.transport.logistica.repository;

import com.transport.logistica.model.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShippingRepository extends JpaRepository<ShippingEntity, Integer> {
}
