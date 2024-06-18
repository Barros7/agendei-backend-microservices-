package com.agendei.projetoagendei.dtos.carWash;

import jakarta.validation.constraints.NotBlank;

public record CarWashRecordDto(
        @NotBlank String name,
        @NotBlank String address,
        @NotBlank String postalCode,
        @NotBlank String phoneNumber,
        @NotBlank String serviceManager,
        @NotBlank String speciality,
        @NotBlank String price
    ) {
    
}
