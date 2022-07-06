package it.unisannio.domain.repository;

import it.unisannio.domain.model.Vehicle;

import java.util.List;

public interface GetVehiclesListPort {
    List<Vehicle> getVehicles();
}
