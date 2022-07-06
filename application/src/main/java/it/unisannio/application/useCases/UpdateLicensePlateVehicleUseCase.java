package it.unisannio.application.useCases;

import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;

import java.util.UUID;

public interface UpdateLicensePlateVehicleUseCase {
    void updateVehicle(UUID id, UpdateLicensePlateVehicleCommand command);
}
