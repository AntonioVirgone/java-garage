package com.avirgone.garage.domain.find.model;

public record Vehicle(
        String code,
        String licensePlate,
        String color,
        String model,
        String brand) {

    public static class Builder {
        private String code;
        private String licensePlate;
        private String color;
        private String model;
        private String brand;

        public Builder withCode(String code) {
            this.code = code;
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

        public Vehicle build() {
            return new Vehicle(code, licensePlate, color, model, brand);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
