package com.avirgone.garage.outbound.find;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.domain.find.repository.FindVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
public class FindVehicleRepositoryImpl implements FindVehicleRepository {
    private final FindVehicleJpaRepository findVehicleJpaRepository;

    @Autowired
    public FindVehicleRepositoryImpl(FindVehicleJpaRepository findVehicleJpaRepository) {
        this.findVehicleJpaRepository = findVehicleJpaRepository;
    }

    @Override
    public CompletionStage<Set<Vehicle>> find(CustomerCode customerCode) {
        return completedFuture(findVehicleJpaRepository.findAll().stream()
                .map(_ -> Vehicle.builder().build()).collect(Collectors.toUnmodifiableSet()));
    }
}
