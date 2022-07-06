package it.unisannio.application.useCases.commands;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateLicensePlateVehicleCommand {
    @NotNull
    @NotBlank
    private String licensePlate;
}
