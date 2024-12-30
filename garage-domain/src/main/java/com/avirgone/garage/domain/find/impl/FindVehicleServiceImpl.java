package com.avirgone.garage.domain.find.impl;

import com.avirgone.garage.domain.find.FindVehicleService;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;
import com.avirgone.garage.domain.find.repository.FindVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.CompletionStage;

@Service
public class FindVehicleServiceImpl implements FindVehicleService {
    private final FindVehicleRepository findVehicleRepository;

    @Autowired
    public FindVehicleServiceImpl(FindVehicleRepository findVehicleRepository) {
        this.findVehicleRepository = findVehicleRepository;
    }

    @Override
    public CompletionStage<Set<Vehicle>> find(CustomerCode customerCode) {
        return findVehicleRepository.find(customerCode);
    }
}
