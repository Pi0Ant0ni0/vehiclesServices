package it.unisannio.infrastructure.mongo.repository;

import it.unisannio.infrastructure.mongo.entity.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
@org.jmolecules.ddd.annotation.Repository
public interface MongoVehicleRepository extends MongoRepository<VehicleEntity, UUID> {
}
