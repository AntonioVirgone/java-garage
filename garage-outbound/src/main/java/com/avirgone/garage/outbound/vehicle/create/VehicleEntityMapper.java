package com.avirgone.garage.outbound.vehicle.create;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.outbound.vehicle.entity.VehicleEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class VehicleEntityMapper implements BiFunction<CustomerCode, Vehicle, VehicleEntity> {
    @Override
    public VehicleEntity apply(CustomerCode customerCode, Vehicle vehicle) {
        return VehicleEntity.builder().withCode(UUID.randomUUID().toString())
                .withCustomerCode(
                        customerCode.code())
                .withLicensePlate(
                        vehicle.licensePlate())
                .withColor(
                        vehicle.color())
                .withModel(
                        vehicle.model())
                .withBrand(
                        vehicle.brand()).build();
    }
}
