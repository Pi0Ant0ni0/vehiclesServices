package it.unisannio.application.useCases;

import it.unisannio.application.useCases.commands.CreateVehicleCommand;

public interface AddVehicleUseCase {
    void addVehicle(CreateVehicleCommand command);
}
