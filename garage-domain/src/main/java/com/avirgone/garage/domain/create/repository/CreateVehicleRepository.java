package com.avirgone.garage.domain.create.repository;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;

import java.util.concurrent.CompletionStage;

public interface CreateVehicleRepository {
    CompletionStage<Void> create(CustomerCode customerCode, Vehicle vehicle);
}
