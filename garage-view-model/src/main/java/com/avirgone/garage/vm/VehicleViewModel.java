package com.avirgone.garage.vm;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema("Car")
public record CarViewModel(String code, String licensePlate, String color, String model, String brand) {
}
