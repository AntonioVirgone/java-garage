package com.avirgone.garage.inbound.api.find;

import com.avirgone.garage.vm.VehicleViewModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.CompletionStage;

@Tag(name = "Vehicle Service", description = "Vehicle Service")
@RestController
@RequestMapping("/api/v1/vehicle")
public class FindVehicleResourceImpl implements FindVehicleResource {
    private final FindVehicleResource delegate;

    @Autowired
    public FindVehicleResourceImpl(FindVehicleResource delegate) {
        this.delegate = delegate;
    }

    @Override
    @GetMapping("/{customerCode}")
    @Operation(summary = "Find vehicles associated to customer", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found vehicles",
                    content = @Content(mediaType = "application/json", schema = @Schema(type = "array", implementation = VehicleViewModel.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content)
    })
    public CompletionStage<Set<VehicleViewModel>> find(@PathVariable Long customerCode) {
        return delegate.find(customerCode);
    }
}
