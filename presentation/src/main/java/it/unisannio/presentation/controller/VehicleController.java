package it.unisannio.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.unisannio.application.useCases.*;
import it.unisannio.application.useCases.commands.CreateVehicleCommand;
import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;
import it.unisannio.domain.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private AddVehicleToTheFleetUseCase addVehicleToTheFleetUseCase;
    @Autowired
    private ViewVehiclesListUseCase viewVehiclesListUseCase;

    @Autowired
    private GetVehicleByUUIDUseCase getVehicleByUUIDUseCase;

    @Autowired
    private RemoveVehicleFromTheFleetUseCase removeVehicleFromTheFleetUseCase;

    @Autowired
    private UpdateLicensePlateVehicleUseCase updateLicensePlateVehicleUseCase;


    @Operation(description = "add a vehicle")
    @PostMapping
    public void get(@Valid @RequestBody CreateVehicleCommand command) {
        this.addVehicleToTheFleetUseCase.addVehicle(command);
    }

    @Operation(description = "get a List of Vehicles")
    @GetMapping
    public List<Vehicle> get(){
        return this.viewVehiclesListUseCase.getVehicles();
    }

    @Operation(description = "get Vehicle from UUID")
    @GetMapping("/{id}")
    public Vehicle get(@PathVariable("id") String uuid){
       return this.getVehicleByUUIDUseCase.getVehicle(UUID.fromString(uuid));
    }

    @Operation(description = "delete Vehicle by UUID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String uuid){
        this.removeVehicleFromTheFleetUseCase.deleteVehicle(UUID.fromString(uuid));
    }

    @Operation(description = "update License Plate of a Vehicle identified by his UUID")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") String uuid, @Valid @RequestBody UpdateLicensePlateVehicleCommand updateLicensePlateVehicleCommand){
        this.updateLicensePlateVehicleUseCase.updateVehicle(UUID.fromString(uuid), updateLicensePlateVehicleCommand);
    }
}
