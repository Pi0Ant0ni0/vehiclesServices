package it.unisannio.domain.repository;

import it.unisannio.domain.model.LicensePlate;
import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface UpdateLicensePlateVehiclePort {
    void updateLicensePlate(Vehicle.VehicleId id, LicensePlate licensePlate);
}
