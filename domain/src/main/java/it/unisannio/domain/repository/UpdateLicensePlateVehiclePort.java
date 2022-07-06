package it.unisannio.domain.repository;

import it.unisannio.domain.model.LicensePlate;

import java.util.UUID;

public interface UpdateLicensePlateVehiclePort {
    void updateLicensePlate(UUID id, String licensePlate);
}
