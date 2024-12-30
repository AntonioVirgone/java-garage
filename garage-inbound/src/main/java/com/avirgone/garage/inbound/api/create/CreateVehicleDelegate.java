package com.avirgone.garage.inbound.api.create;

import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@Component
@RequestScope
public class CreateVehicleDelegate implements CreateVehicleResource {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public CompletionStage<Void> create(Long customerCode, VehicleViewModel vehicle) {
        log.info(() -> "Create %s associate to account %d".formatted(vehicle, customerCode));

        return null;
    }
}
