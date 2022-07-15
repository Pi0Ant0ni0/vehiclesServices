package it.unisannio.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("vehicles")
@AllArgsConstructor
public class VehicleEntity {
    @Id
    private UUID id;
    private String friendlyName;
    private String licensePlate;
    /**
     * dimension are in cm, we approximate to cm so they are integer
     */
    private int length;
    private int height;
    private int depth;
    /**
     * unit measure: m^3
     */
    private int capacity;
    private String state;
}
