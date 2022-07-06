package it.unisannio.domain.repository;

import it.unisannio.domain.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface GetVehicleByUUIDPort {
    Vehicle getVehicleByUUID(UUID uuid);
}
