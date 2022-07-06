package it.unisannio.domain.repository;

import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface DeleteVehicleByUUIDPort {
    void deleteVehicleByUUID(UUID uuid);
}
