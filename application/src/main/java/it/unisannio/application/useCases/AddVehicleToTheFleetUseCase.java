package it.unisannio.application.useCases;

import it.unisannio.application.useCases.commands.CreateVehicleCommand;

public interface AddVehicleToTheFleetUseCase {
    void addVehicle(CreateVehicleCommand command);
}
