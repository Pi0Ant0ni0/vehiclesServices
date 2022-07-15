package it.unisannio.application.services;

import it.unisannio.application.useCases.UpdateLicensePlateVehicleUseCase;
import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;
import it.unisannio.domain.model.LicensePlate;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.UpdateLicensePlateVehiclePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UpdateVehicleService implements UpdateLicensePlateVehicleUseCase {

    @Autowired
    private UpdateLicensePlateVehiclePort updateLicensePlateVehiclePort;


    @Override
    public void updateVehicle(Vehicle.VehicleId id, UpdateLicensePlateVehicleCommand command) {
        this.updateLicensePlateVehiclePort.updateLicensePlate(id, new LicensePlate(command.getLicensePlate()));
    }
}
