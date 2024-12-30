package com.avirgone.garage.domain.find.repository;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;

import java.util.Set;
import java.util.concurrent.CompletionStage;

public interface FindVehicleRepository {
    CompletionStage<Set<Vehicle>> find(CustomerCode customerCode);
}
