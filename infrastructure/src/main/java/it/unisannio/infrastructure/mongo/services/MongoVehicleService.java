package it.unisannio.infrastructure.mongo.services;

import it.unisannio.domain.model.LicensePlate;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.*;
import it.unisannio.infrastructure.mongo.entity.VehicleEntity;
import it.unisannio.infrastructure.mongo.mapper.VehicleMapper;
import it.unisannio.infrastructure.mongo.repository.MongoVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MongoVehicleService implements AddVehiclePort, GetVehiclesListPort, GetVehicleByUUIDPort, DeleteVehicleByUUIDPort, UpdateLicensePlateVehiclePort {

    @Autowired
    MongoVehicleRepository mongoVehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = VehicleMapper.toEntity(vehicle);
        this.mongoVehicleRepository.save(vehicleEntity);
    }

    @Override
    public List<Vehicle> getVehicles() {
        List<VehicleEntity> entities = this.mongoVehicleRepository.findAll();
        List<Vehicle> vehicles = new ArrayList<>();
        entities.forEach(entity -> vehicles.add(VehicleMapper.toDomain(entity)));

        return vehicles;
    }

    @Override
    public Vehicle getVehicleByUUID(UUID uuid) {
        Optional<VehicleEntity> entityOptional = this.mongoVehicleRepository.findById(uuid);

        if(entityOptional.isPresent()){
            return VehicleMapper.toDomain(entityOptional.get());
        }
        return null;
    }

    @Override
    public void deleteVehicleByUUID(UUID uuid) {
        this.mongoVehicleRepository.deleteById(uuid);
    }

    @Override
    public void updateLicensePlate(UUID id, String licensePlate) {
        Optional<VehicleEntity> entityOptional = this.mongoVehicleRepository.findById(id);

        if(entityOptional.isPresent()){

            Vehicle toUpdate = VehicleMapper.toDomain(entityOptional.get());
            toUpdate.updateLicensePlate(licensePlate);

            this.mongoVehicleRepository.save(VehicleMapper.toEntity(toUpdate));

        }

    }
}
