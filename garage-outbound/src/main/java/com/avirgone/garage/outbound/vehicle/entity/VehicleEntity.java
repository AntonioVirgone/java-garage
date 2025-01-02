package com.avirgone.garage.outbound.vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleEntity {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String code;
    private Long customerCode;
    private String licensePlate;
    private String color;
    private String model;
    private String brand;

    public VehicleEntity() {
    }

    public VehicleEntity(String code, Long customerCode, String licensePlate, String color, String model, String brand) {
        this.code = code;
        this.customerCode = customerCode;
        this.licensePlate = licensePlate;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public Long getCustomerCode() {
        return customerCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public static class Builder {
        private String code;
        private Long customerCode;
        private String licensePlate;
        private String color;
        private String model;
        private String brand;

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withCustomerCode(Long customerCode) {
            this.customerCode = customerCode;
            return this;
        }

        public Builder withLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public VehicleEntity build() {
            return new VehicleEntity(code, customerCode, licensePlate, color, model, brand);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
