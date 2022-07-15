package it.unisannio.domain.repository;

import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface DeleteVehicleByIDPort {
    void deleteVehicleByVehicleID(Vehicle.VehicleId id);
}
