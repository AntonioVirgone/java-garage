package com.avirgone.garage.outbound.find;

import com.avirgone.garage.outbound.find.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FindVehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
}
