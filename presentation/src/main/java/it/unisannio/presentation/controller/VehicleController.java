package it.unisannio.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.unisannio.application.useCases.*;
import it.unisannio.application.useCases.commands.CreateVehicleCommand;
import it.unisannio.application.useCases.commands.UpdateLicensePlateVehicleCommand;
import it.unisannio.domain.model.Vehicle;
import it.unisannio.presentation.DTO.VehicleDTO;
import it.unisannio.presentation.Mapper.VehicleDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    private GetVehicleByIDUseCase getVehicleByIDUseCase;

    @Autowired
    private RemoveVehicleFromTheFleetUseCase removeVehicleFromTheFleetUseCase;

    @Autowired
    private UpdateLicensePlateVehicleUseCase updateLicensePlateVehicleUseCase;

    @Autowired
    private VehicleDTOMapper vehicleDTOMapper;


    @Operation(description = "add a vehicle")
    @PostMapping
    public void get(@Valid @RequestBody CreateVehicleCommand command) {
        this.addVehicleToTheFleetUseCase.addVehicle(command);
    }

    @Operation(description = "get a List of Vehicles")
    @GetMapping
    public List<VehicleDTO> get(){
        List<Vehicle> list = this.viewVehiclesListUseCase.getVehicles();

        List<VehicleDTO> dtos = new ArrayList<>();
        list.forEach(v -> dtos.add(vehicleDTOMapper.apply(v)));
        return dtos;
    }

    @Operation(description = "get Vehicle from UUID")
    @GetMapping("/{id}")
    public VehicleDTO get(@PathVariable("id") String uuid){
       Vehicle v = this.getVehicleByIDUseCase.getVehicle(new Vehicle.VehicleId(UUID.fromString(uuid)));
       return vehicleDTOMapper.apply(v);
    }

    @Operation(description = "delete Vehicle by UUID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String uuid){
        this.removeVehicleFromTheFleetUseCase.deleteVehicle(new Vehicle.VehicleId(UUID.fromString(uuid)));
    }

    @Operation(description = "update License Plate of a Vehicle identified by his UUID")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") String uuid, @Valid @RequestBody UpdateLicensePlateVehicleCommand updateLicensePlateVehicleCommand){
        this.updateLicensePlateVehicleUseCase.updateVehicle(new Vehicle.VehicleId(UUID.fromString(uuid)), updateLicensePlateVehicleCommand);
    }
}
