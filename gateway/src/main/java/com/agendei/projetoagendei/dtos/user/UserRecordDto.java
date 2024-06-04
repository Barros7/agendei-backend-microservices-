package com.agendei.projetoagendei.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String phone,
        @NotBlank String password
    ) {

}
