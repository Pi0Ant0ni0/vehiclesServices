package it.unisannio.infrastructure.mongo.services;

import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.AddVehiclePort;
import it.unisannio.infrastructure.mongo.entity.VehicleEntity;
import it.unisannio.infrastructure.mongo.mapper.VehicleMapper;
import it.unisannio.infrastructure.mongo.repository.MongoVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoVehicleService implements AddVehiclePort {

    @Autowired
    MongoVehicleRepository mongoVehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = VehicleMapper.toEntity(vehicle);
        this.mongoVehicleRepository.save(vehicleEntity);
    }
}
