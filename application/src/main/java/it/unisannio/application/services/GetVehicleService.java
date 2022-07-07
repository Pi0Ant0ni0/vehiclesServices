package it.unisannio.application.services;

import it.unisannio.application.useCases.GetVehicleByUUIDUseCase;
import it.unisannio.application.useCases.ViewVehiclesListUseCase;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.GetVehicleByUUIDPort;
import it.unisannio.domain.repository.GetVehiclesListPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetVehicleService implements ViewVehiclesListUseCase, GetVehicleByUUIDUseCase {

    @Autowired
    private GetVehiclesListPort getVehiclesListPort;

    @Autowired
    private GetVehicleByUUIDPort getVehicleByUUIDPort;

    @Override
    public List<Vehicle> getVehicles() {
        return this.getVehiclesListPort.getVehicles();
    }

    @Override
    public Vehicle getVehicle(UUID uuid) {
        return this.getVehicleByUUIDPort.getVehicleByUUID(uuid);
    }
}
