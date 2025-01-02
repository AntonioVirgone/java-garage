package com.avirgone.garage.inbound.api.create;

import com.avirgone.garage.vm.VehicleViewModel;

import java.util.concurrent.CompletionStage;

public interface CreateVehicleResource {
    CompletionStage<Void> create(Long customerCode, VehicleViewModel vehicle);
}
