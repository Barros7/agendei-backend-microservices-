package com.agendei.projetoagendei.dtos.carWash;

import jakarta.validation.constraints.NotBlank;

public record CarWashRecordDto(
        @NotBlank String carWashId,
        @NotBlank String dateCarWash,
        @NotBlank String hourCarWash,
        @NotBlank String carWashState
    ) {
    
}
