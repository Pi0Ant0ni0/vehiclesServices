package it.unisannio.application.services;

import it.unisannio.application.useCases.RemoveVehicleFromTheFleetUseCase;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.DeleteVehicleByIDPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DeleteVehicleService implements RemoveVehicleFromTheFleetUseCase {

    @Autowired
    private DeleteVehicleByIDPort deleteVehicleByIDPort;

    @Override
    public void deleteVehicle(Vehicle.VehicleId id) {
        this.deleteVehicleByIDPort.deleteVehicleByVehicleID(id);
    }
}
