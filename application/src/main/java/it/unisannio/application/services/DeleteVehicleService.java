package it.unisannio.application.services;

import it.unisannio.application.useCases.RemoveVehicleFromTheFleetUseCase;
import it.unisannio.domain.repository.DeleteVehicleByUUIDPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DeleteVehicleService implements RemoveVehicleFromTheFleetUseCase {

    @Autowired
    private DeleteVehicleByUUIDPort deleteVehicleByUUIDPort;

    @Override
    public void deleteVehicle(UUID uuid) {
        this.deleteVehicleByUUIDPort.deleteVehicleByUUID(uuid);
    }
}
