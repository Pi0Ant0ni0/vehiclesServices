package it.unisannio.domain.repository;

import it.unisannio.domain.model.Vehicle;

public interface GetVehicleByIDPort {
    Vehicle getVehicleByVehicleID(Vehicle.VehicleId id);
}
