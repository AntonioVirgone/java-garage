package com.avirgone.garage.inbound.api.find;

import com.avirgone.garage.vm.VehicleViewModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
@RequestScope
public class FindCarDelegate implements FindCarResource {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public CompletionStage<Set<VehicleViewModel>> find(Long customerCode) {
        log.info(() -> "Find vehicles associate to account %d".formatted(customerCode));
        return completedFuture(null);
    }
}
