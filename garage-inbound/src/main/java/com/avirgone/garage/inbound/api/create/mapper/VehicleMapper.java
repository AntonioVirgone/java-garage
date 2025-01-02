package com.avirgone.garage.inbound.api.create.mapper;

import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicleMapper implements Function<VehicleViewModel, Vehicle> {
    @Override
    public Vehicle apply(VehicleViewModel vehicleViewModel) {
        return Vehicle.builder()
                .withCode(vehicleViewModel.code())
                .withLicensePlate(vehicleViewModel.licensePlate())
                .withColor(vehicleViewModel.color())
                .withBrand(vehicleViewModel.brand())
                .withModel(vehicleViewModel.model()).build();
    }
}
