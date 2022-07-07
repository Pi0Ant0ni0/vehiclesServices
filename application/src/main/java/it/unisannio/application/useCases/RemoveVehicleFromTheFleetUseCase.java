package it.unisannio.application.useCases;

import java.util.UUID;

public interface RemoveVehicleFromTheFleetUseCase {
    void deleteVehicle(UUID uuid);
}
