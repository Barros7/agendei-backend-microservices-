package com.agendei.projetoagendei.dtos.clinic;

import jakarta.validation.constraints.NotBlank;

public record ClinicRecordDto(
        @NotBlank String name,
        @NotBlank String address,
        @NotBlank String postalCode,
        @NotBlank String phoneNumber,
        @NotBlank String doctor,
        @NotBlank String speciality,
        @NotBlank String price
    ) {

    
}
