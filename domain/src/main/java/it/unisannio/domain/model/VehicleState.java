package it.unisannio.domain.model;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public enum VehicleState {
    STOPPED,
    IN_TRANSIT
}
