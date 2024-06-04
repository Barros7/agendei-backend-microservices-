package com.agendei.projetoagendei.dtos.medicalAppointment;

import jakarta.validation.constraints.NotBlank;

public record MedicalAppointmentRecordDto(
        @NotBlank String patientId,
        @NotBlank String dateMedicalAppointment,
        @NotBlank String hourMedicalAppointment,
        @NotBlank String medicalAppointmentState
    ) {
    
}
