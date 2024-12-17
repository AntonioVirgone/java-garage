package com.avirgone.garage.vm;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(name = "Vehicle", description = "Vehicle representation")
public record VehicleViewModel(@Schema(description = "Unique code of vehicle", example = "123acb") String code,
                               @Schema(description = "License plate associate to vehicle", example = "AB123CD", requiredMode = REQUIRED) String licensePlate,
                               @Schema(description = "Color of vehicle", example = "white") String color,
                               @Schema(description = "Model of vehicle", example = "Duster") String model,
                               @Schema(description = "Brand of vehicle", example = "Dacia") String brand) {
}
