package com.avirgone.garage.inbound.api.find;

import com.avirgone.garage.domain.find.FindVehicleService;
import com.avirgone.garage.domain.find.model.CustomerCode;
import com.avirgone.garage.inbound.api.find.mapper.VehicleViewModelSetMapper;
import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@Component
@RequestScope
public class FindVehicleDelegate implements FindVehicleResource {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final FindVehicleService findVehicleService;
    private final VehicleViewModelSetMapper vehicleViewModelSetMapper;

    @Autowired
    public FindVehicleDelegate(FindVehicleService findVehicleService, VehicleViewModelSetMapper vehicleViewModelSetMapper) {
        this.findVehicleService = findVehicleService;
        this.vehicleViewModelSetMapper = vehicleViewModelSetMapper;
    }

    @Override
    public CompletionStage<Set<VehicleViewModel>> find(Long customerCode) {
        log.info(() -> "Find vehicles associate to account %d".formatted(customerCode));
        return findVehicleService.find(new CustomerCode(customerCode)).thenApply(vehicleViewModelSetMapper);
    }
}
