package it.unisannio.application.useCases;

import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface GetVehicleByIDUseCase {
    Vehicle getVehicle(Vehicle.VehicleId id);
}
