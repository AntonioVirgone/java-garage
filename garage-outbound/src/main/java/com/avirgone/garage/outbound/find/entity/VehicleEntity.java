package com.avirgone.garage.outbound.find.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record VehicleEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id) { }
