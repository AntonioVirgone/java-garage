package com.avirgone.garage.domain.create.impl;

import com.avirgone.garage.domain.create.CreateVehicleService;
import com.avirgone.garage.domain.create.repository.CreateVehicleRepository;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionStage;

@Service
public class CreateVehicleServiceImpl implements CreateVehicleService {
    private final CreateVehicleRepository createVehicleRepository;

    @Autowired
    public CreateVehicleServiceImpl(CreateVehicleRepository createVehicleRepository) {
        this.createVehicleRepository = createVehicleRepository;
    }

    @Override
    public CompletionStage<Void> create(CustomerCode customerCode, Vehicle vehicle) {
        return createVehicleRepository.create(customerCode, vehicle);
    }
}
