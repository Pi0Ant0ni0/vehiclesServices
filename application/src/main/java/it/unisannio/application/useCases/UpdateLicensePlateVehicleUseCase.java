package it.unisannio.application.useCases;

import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;
import it.unisannio.domain.model.Vehicle;

import java.util.UUID;

public interface UpdateLicensePlateVehicleUseCase {
    void updateVehicle(Vehicle.VehicleId id, UpdateLicensePlateVehicleCommand command);
}
