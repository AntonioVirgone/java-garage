package com.avirgone.garage.domain.find.impl;

import com.avirgone.garage.domain.find.FindVehicleService;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Service
public class FindVehicleServiceImpl implements FindVehicleService {
    @Override
    public CompletionStage<Set<Vehicle>> find(CustomerCode customerCode) {
        return completedFuture(Set.of(Vehicle.builder().withCode("abc").withLicensePlate("AB123CD").withColor("black").build()));
    }
}
