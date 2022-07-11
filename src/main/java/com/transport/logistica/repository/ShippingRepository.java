package com.transport.logistica.repository;

import com.transport.logistica.model.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ShippingRepository extends JpaRepository<ShippingEntity, Integer> {
}
