package it.unisannio.application.services;

import it.unisannio.domain.repository.AddVehiclePort;
import it.unisannio.application.useCases.AddVehicleUseCase;
import it.unisannio.application.useCases.commands.CreateVehicleCommand;
import it.unisannio.domain.exceptions.LicensePlateException;
import it.unisannio.domain.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleService implements AddVehicleUseCase {

    @Autowired
    private AddVehiclePort addVehiclePort;

    @Override
    public void addVehicle(CreateVehicleCommand command) throws LicensePlateException {
        Vehicle aVehicle = new Vehicle(
                UUID.randomUUID(),
                command.getLicensePlate(),
                command.getLength(),
                command.getHeight(),
                command.getDepth(),
                command.getCapacity()
        );
        this.addVehiclePort.addVehicle(aVehicle);
    }
}
