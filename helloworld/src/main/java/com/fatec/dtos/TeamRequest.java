package com.fatec.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TeamRequest(
        @NotBlank String name,
        @NotBlank String country,
        @NotBlank String matchDay,
        @NotNull @PositiveOrZero Integer wins,
        @NotNull @PositiveOrZero Integer losses,
        @NotNull @PositiveOrZero Integer draws,
        @NotNull @PositiveOrZero Integer cupPoints) {
}
