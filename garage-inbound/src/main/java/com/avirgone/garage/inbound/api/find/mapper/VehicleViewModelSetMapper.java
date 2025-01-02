package com.avirgone.garage.inbound.api.find.mapper;

import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class VehicleViewModelSetMapper implements Function<Set<Vehicle>, Set<VehicleViewModel>> {

    private final VehicleViewModelMapper vehicleViewModelMapper;

    @Autowired
    public VehicleViewModelSetMapper(VehicleViewModelMapper vehicleViewModelMapper) {
        this.vehicleViewModelMapper = vehicleViewModelMapper;
    }

    @Override
    public Set<VehicleViewModel> apply(Set<Vehicle> vehicles) {
        return vehicles.stream().map(vehicleViewModelMapper).collect(Collectors.toUnmodifiableSet());
    }
}
