package com.avirgone.garage.inbound.api.find;

import com.avirgone.garage.vm.VehicleViewModel;

import java.util.Set;
import java.util.concurrent.CompletionStage;

public interface FindVehicleResource {
    CompletionStage<Set<VehicleViewModel>> find(Long customerCode);
}
