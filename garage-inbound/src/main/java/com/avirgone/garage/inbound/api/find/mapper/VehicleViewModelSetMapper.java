package com.avirgone.garage.inbound.api.find.mapper;

import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.vm.VehicleViewModel;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface VehicleViewModelSetMapper extends Function<Set<Vehicle>, Set<VehicleViewModel>> {
    @Override
    Set<VehicleViewModel> apply(Set<Vehicle> vehicles);
}
