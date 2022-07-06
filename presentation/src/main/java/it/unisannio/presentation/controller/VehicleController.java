package it.unisannio.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.unisannio.application.useCases.AddVehicleUseCase;
import it.unisannio.application.useCases.commands.CreateVehicleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private AddVehicleUseCase addVehicleUseCase;


    @Operation(description = "add a vehicle")
    @PostMapping
    public void get(@Valid @RequestBody CreateVehicleCommand command) {
        this.addVehicleUseCase.addVehicle(command);

    }
}
