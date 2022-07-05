package it.unisannio.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface Repository extends MongoRepository<EntityDiProva, UUID> {
}
