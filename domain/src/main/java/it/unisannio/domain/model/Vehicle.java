package it.unisannio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@AggregateRoot
@Getter
public class Vehicle {

    private final VehicleId id;
    private LicensePlate licensePlate;
    /**
     * dimension are in cm, we approximate to cm so they are integer
     */
    private final int length;
    private final int height;
    private final int depth;
    /**
     * unit measure: l
     */
    private final float capacity;
    private VehicleState state;

    /**
     * @throws it.unisannio.domain.exceptions.LicensePlateException if license plate format is not correct
     */
    public Vehicle(UUID id, String licensePlate, int length, int height, int depth, float capacity) {
        this.id = new VehicleId(id);
        this.licensePlate = new LicensePlate(licensePlate);
        this.length = length;
        this.height = height;
        this.depth = depth;
        this.capacity = capacity;
        state = VehicleState.STOPPED;
    }

    @Value
    @ValueObject
    public class VehicleId {
        private UUID id;
    }

    public void updateState(VehicleState state) {
        this.state = state;
    }

    public void updateLicensePlate(String licensePlate) {
        this.licensePlate = new LicensePlate(licensePlate);
    }
}