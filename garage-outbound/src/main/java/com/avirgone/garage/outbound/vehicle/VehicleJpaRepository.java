package com.avirgone.garage.outbound.vehicle;

import com.avirgone.garage.outbound.vehicle.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
}
