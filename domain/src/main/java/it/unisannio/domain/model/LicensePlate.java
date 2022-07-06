package it.unisannio.domain.model;

import it.unisannio.domain.exceptions.LicensePlateException;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Value
public class LicensePlate {
    private String licensePlate;

    /**
     * @throws LicensePlateException if licensePlate format is not correct
     */
    public LicensePlate(String licensePlate) {
        if (licensePlate.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$")) {
            this.licensePlate = licensePlate;
        } else {
            throw new LicensePlateException("Invalid license plate: " + licensePlate + "\n" +
                    "LicensePlate must be in the format AA000BB");
        }
    }
}
