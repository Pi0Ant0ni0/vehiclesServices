package it.unisannio.application.services;

import it.unisannio.application.useCases.GetVehicleByIDUseCase;
import it.unisannio.application.useCases.ViewVehiclesListUseCase;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.GetVehicleByIDPort;
import it.unisannio.domain.repository.GetVehiclesListPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVehicleService implements ViewVehiclesListUseCase, GetVehicleByIDUseCase {

    @Autowired
    private GetVehiclesListPort getVehiclesListPort;

    @Autowired
    private GetVehicleByIDPort getVehicleByIDPort;

    @Override
    public List<Vehicle> getVehicles() {
        return this.getVehiclesListPort.getVehicles();
    }

    @Override
    public Vehicle getVehicle(Vehicle.VehicleId id) {
        return this.getVehicleByIDPort.getVehicleByVehicleID(id);
    }
}
