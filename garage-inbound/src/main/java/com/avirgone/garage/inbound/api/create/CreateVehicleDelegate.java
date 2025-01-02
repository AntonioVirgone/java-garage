package com.avirgone.garage.inbound.api.create;

import com.avirgone.garage.domain.create.CreateVehicleService;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.inbound.api.create.mapper.VehicleMapper;
import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@Component
@RequestScope
public class CreateVehicleDelegate implements CreateVehicleResource {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final VehicleMapper vehicleMapper;
    private final CreateVehicleService createVehicleService;

    @Autowired
    public CreateVehicleDelegate(VehicleMapper vehicleMapper, CreateVehicleService createVehicleService) {
        this.vehicleMapper = vehicleMapper;
        this.createVehicleService = createVehicleService;
    }

    @Override
    public CompletionStage<Void> create(Long customerCode, VehicleViewModel vehicle) {
        log.info(() -> "Create %s associate to account %d".formatted(vehicle, customerCode));

        return createVehicleService.create(new CustomerCode(customerCode), vehicleMapper.apply(vehicle));
    }
}
