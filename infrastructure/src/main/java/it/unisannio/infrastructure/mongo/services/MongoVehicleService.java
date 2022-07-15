package it.unisannio.infrastructure.mongo.services;

import it.unisannio.domain.exceptions.EntityNotFoundException;
import it.unisannio.domain.model.LicensePlate;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.domain.repository.*;
import it.unisannio.infrastructure.mongo.entity.VehicleEntity;
import it.unisannio.infrastructure.mongo.mapper.VehicleMapper;
import it.unisannio.infrastructure.mongo.repository.MongoVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MongoVehicleService implements AddVehiclePort, GetVehiclesListPort, GetVehicleByIDPort, DeleteVehicleByIDPort, UpdateLicensePlateVehiclePort {

    @Autowired
    MongoVehicleRepository mongoVehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = VehicleMapper.toEntity(vehicle);
        this.mongoVehicleRepository.save(vehicleEntity);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.mongoVehicleRepository.findAll().stream().map(v -> VehicleMapper.toDomain(v)).collect(Collectors.toList());
    }

    @Override
    public Vehicle getVehicleByVehicleID(Vehicle.VehicleId id) {

        return this.mongoVehicleRepository.findById(id.getId())
                .map(v -> VehicleMapper.toDomain(v))
                .orElseThrow(() -> new EntityNotFoundException("Vehicle with id: "+id.getId()+" + not found."));
    }

    @Override
    public void deleteVehicleByVehicleID(Vehicle.VehicleId id) {
        this.mongoVehicleRepository.deleteById(id.getId());
    }

    @Override
    public void updateLicensePlate(Vehicle.VehicleId id, LicensePlate licensePlate) {
        VehicleEntity entity = this.mongoVehicleRepository.findById(id.getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle with id: "+id.getId()+" + not found."));

        entity.setLicensePlate(licensePlate.getLicensePlate());
        this.mongoVehicleRepository.save(entity);
    }
}
