package com.avirgone.garage.outbound.vehicle.entity;

import com.avirgone.garage.domain.find.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicleFromVehicleEntityMapper implements Function<VehicleEntity, Vehicle> {
    @Override
    public Vehicle apply(VehicleEntity vehicleEntity) {
        return Vehicle.builder()
                .withCode(vehicleEntity.getCode())
                .withLicensePlate(vehicleEntity.getLicensePlate())
                .withColor(vehicleEntity.getColor())
                .withBrand(vehicleEntity.getBrand())
                .withModel(vehicleEntity.getModel())
                .build();
    }
}
