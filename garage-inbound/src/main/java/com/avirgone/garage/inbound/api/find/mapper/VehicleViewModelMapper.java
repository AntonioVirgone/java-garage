package com.avirgone.garage.inbound.api.find.mapper;

import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicleViewModelMapper implements Function<Vehicle, VehicleViewModel> {
    @Override
    public VehicleViewModel apply(Vehicle vehicle) {
        return new VehicleViewModel(vehicle.code(), vehicle.licensePlate(), vehicle.color(), vehicle.model(), vehicle.brand());
    }
}
