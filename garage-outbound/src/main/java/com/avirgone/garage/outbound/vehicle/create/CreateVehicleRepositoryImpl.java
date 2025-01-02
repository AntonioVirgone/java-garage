package com.avirgone.garage.outbound.vehicle.create;

import com.avirgone.garage.domain.create.repository.CreateVehicleRepository;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.outbound.vehicle.VehicleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Repository
public class CreateVehicleRepositoryImpl implements CreateVehicleRepository {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final VehicleEntityMapper vehicleEntityMapper;
    private final VehicleJpaRepository vehicleJpaRepository;

    @Autowired
    public CreateVehicleRepositoryImpl(VehicleEntityMapper vehicleEntityMapper, VehicleJpaRepository vehicleJpaRepository) {
        this.vehicleEntityMapper = vehicleEntityMapper;
        this.vehicleJpaRepository = vehicleJpaRepository;
    }

    @Override
    public CompletionStage<Void> create(CustomerCode customerCode, Vehicle vehicle) {
        return completedFuture(vehicleJpaRepository.save(vehicleEntityMapper.apply(customerCode, vehicle)))
                .thenRun(() -> log.info("Vehicle created: " + vehicle));
    }
}
