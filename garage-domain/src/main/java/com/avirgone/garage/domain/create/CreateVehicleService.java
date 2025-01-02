package com.avirgone.garage.domain.create;

import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.domain.find.model.Vehicle;

import java.util.concurrent.CompletionStage;

public interface CreateVehicleService {
    CompletionStage<Void> create(CustomerCode customerCode, Vehicle vehicle);
}
