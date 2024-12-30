package com.avirgone.garage.inbound.api.create;

import com.avirgone.garage.vm.VehicleViewModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

@Tag(name = "Vehicle Service", description = "Vehicle Service")
@RestController
@RequestMapping("/api/v1/vehicle")
public class CreateVehicleResourceImpl implements CreateVehicleResource {
    private final CreateVehicleDelegate delegate;

    @Autowired
    public CreateVehicleResourceImpl(CreateVehicleDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    @PostMapping("/{customerCode}")
    @Operation(summary = "Create new vehicle associated to customer", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Created vehicle",
                    content = @Content(mediaType = "application/json", schema = @Schema(type = "array", implementation = VehicleViewModel.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content)
    })
    public CompletionStage<Void> create(@PathVariable Long customerCode, @RequestBody VehicleViewModel vehicle) {
        return delegate.create(customerCode, vehicle);
    }
}
