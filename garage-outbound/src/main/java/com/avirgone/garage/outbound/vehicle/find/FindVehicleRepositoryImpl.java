package com.avirgone.garage.outbound.vehicle.find;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.domain.find.repository.FindVehicleRepository;
import com.avirgone.garage.outbound.vehicle.VehicleJpaRepository;
import com.avirgone.garage.outbound.vehicle.entity.VehicleFromVehicleEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
public class FindVehicleRepositoryImpl implements FindVehicleRepository {
    private final VehicleJpaRepository vehicleJpaRepository;
    private final VehicleFromVehicleEntityMapper vehicleFromVehicleEntityMapper;

    @Autowired
    public FindVehicleRepositoryImpl(VehicleJpaRepository vehicleJpaRepository, VehicleFromVehicleEntityMapper vehicleFromVehicleEntityMapper) {
        this.vehicleJpaRepository = vehicleJpaRepository;
        this.vehicleFromVehicleEntityMapper = vehicleFromVehicleEntityMapper;
    }

    @Override
    public CompletionStage<Set<Vehicle>> find(CustomerCode customerCode) {
        return completedFuture(vehicleJpaRepository.findAll().stream()
                .map(vehicleFromVehicleEntityMapper).collect(Collectors.toUnmodifiableSet()));
    }
}
