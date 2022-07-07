package it.unisannio.application.useCases;

import it.unisannio.domain.model.Vehicle;

import java.util.List;

public interface ViewVehiclesListUseCase {
    List<Vehicle> getVehicles();
}
