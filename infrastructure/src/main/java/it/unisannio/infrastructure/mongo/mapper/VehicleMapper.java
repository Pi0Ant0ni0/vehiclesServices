package it.unisannio.infrastructure.mongo.mapper;

import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.model.VehicleState;
import it.unisannio.infrastructure.mongo.entity.VehicleEntity;


public class VehicleMapper {

    public static Vehicle toDomain(VehicleEntity entity) {
        Vehicle aVehicle = new Vehicle(
                entity.getId(),
                entity.getLicensePlate(),
                entity.getLength(),
                entity.getHeight(),
                entity.getDepth(),
                entity.getCapacity()
        );

        aVehicle.updateState(VehicleState.valueOf(entity.getState()));
        return aVehicle;

    }

    public static VehicleEntity toEntity(Vehicle vehicle) {
        return new VehicleEntity(
                vehicle.getId().getId(),
                vehicle.getLicensePlate().getLicensePlate(),
                vehicle.getLength(),
                vehicle.getHeight(),
                vehicle.getDepth(),
                vehicle.getCapacity(),
                vehicle.getState().name()
        );
    }
}
