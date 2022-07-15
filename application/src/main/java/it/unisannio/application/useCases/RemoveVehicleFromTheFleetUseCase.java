package it.unisannio.application.useCases;

import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface RemoveVehicleFromTheFleetUseCase {
    void deleteVehicle(Vehicle.VehicleId id);
}
