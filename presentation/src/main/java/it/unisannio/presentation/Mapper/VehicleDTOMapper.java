package it.unisannio.presentation.Mapper;

import it.unisannio.domain.model.Vehicle;
import it.unisannio.presentation.DTO.VehicleDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicleDTOMapper implements Function<Vehicle, VehicleDTO> {
    @Override
    public VehicleDTO apply(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId().getId(), vehicle.getFriendlyName(), vehicle.getLicensePlate().getLicensePlate(), vehicle.getLength(), vehicle.getHeight(), vehicle.getDepth(), vehicle.getCapacity(), vehicle.getState().name());
    }
}
