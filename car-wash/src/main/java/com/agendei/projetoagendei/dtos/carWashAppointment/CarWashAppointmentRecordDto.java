package com.agendei.projetoagendei.dtos.carWashAppointment;

import jakarta.validation.constraints.NotBlank;

public record CarWashAppointmentRecordDto(
        @NotBlank String userId,
        @NotBlank String carWashId,
        @NotBlank String dateCarWashAppointment,
        @NotBlank String hourCarWashAppointment,
        @NotBlank String carWashAppointmentState
    ) {
    
}
