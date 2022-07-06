package it.unisannio.application.services;

import it.unisannio.application.useCases.*;
import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;
import it.unisannio.domain.model.LicensePlate;
import it.unisannio.domain.repository.*;
import it.unisannio.application.useCases.commands.CreateVehicleCommand;
import it.unisannio.domain.exceptions.LicensePlateException;
import it.unisannio.domain.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService implements AddVehicleUseCase, GetVehiclesListUseCase, GetVehicleByUUIDUseCase, DeleteVehicleByUUIDUseCase, UpdateLicensePlateVehicleUseCase {

    @Autowired
    private AddVehiclePort addVehiclePort;
    @Autowired
    private GetVehiclesListPort getVehiclesListPort;

    @Autowired
    private GetVehicleByUUIDPort getVehicleByUUIDPort;

    @Autowired
    private DeleteVehicleByUUIDPort deleteVehicleByUUIDPort;

    @Autowired
    private UpdateLicensePlateVehiclePort updateLicensePlateVehiclePort;

    @Override
    public void addVehicle(CreateVehicleCommand command) throws LicensePlateException {
        Vehicle aVehicle = new Vehicle(
                UUID.randomUUID(),
                command.getFriendlyName(),
                command.getLicensePlate(),
                command.getLength(),
                command.getHeight(),
                command.getDepth(),
                command.getCapacity()
        );
        this.addVehiclePort.addVehicle(aVehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
       return this.getVehiclesListPort.getVehicles();
    }

    @Override
    public Vehicle getVehicle(UUID uuid) {
        return this.getVehicleByUUIDPort.getVehicleByUUID(uuid);
    }

    @Override
    public void deleteVehicle(UUID uuid) {
        this.deleteVehicleByUUIDPort.deleteVehicleByUUID(uuid);
    }

    @Override
    public void updateVehicle(UUID id, UpdateLicensePlateVehicleCommand command) {
        this.updateLicensePlateVehiclePort.updateLicensePlate(id, command.getLicensePlate());
    }
}
