package it.unisannio.application.useCases;

import it.unisannio.domain.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface GetVehicleByUUIDUseCase {
    Vehicle getVehicle(UUID uuid);
}
