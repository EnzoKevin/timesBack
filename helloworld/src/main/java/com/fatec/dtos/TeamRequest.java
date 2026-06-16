package com.fatec.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record TeamRequest(
        @NotBlank(message = "O nome da equipe não pode ser em branco")
        @Size(min = 3, max = 100, message = "O nome da equipe deve ter entre 3 e 100 caracteres") String name,
        @NotBlank(message = "O país não pode ser em branco")
        @Size(min = 3, max = 100, message = "O país deve ter entre 3 e 100 caracteres") String country,
        @NotNull(message = "O número de vitórias não pode ser nulo")
        @PositiveOrZero(message = "O número de vitórias não pode ser negativo")
        @Max(value = 100, message = "O número de vitórias não pode ser maior que 100") Integer wins,
        @NotNull(message = "O número de derrotas não pode ser nulo")
        @PositiveOrZero(message = "O número de derrotas não pode ser negativo")
        @Max(value = 100, message = "O número de derrotas não pode ser maior que 100") Integer losses,
        @NotNull(message = "O número de empates não pode ser nulo")
        @PositiveOrZero(message = "O número de empates não pode ser negativo")
        @Max(value = 100, message = "O número de empates não pode ser maior que 100") Integer draws,
        @NotNull(message = "Os pontos da copa não podem ser nulos")
        @PositiveOrZero(message = "Os pontos da copa não podem ser negativos")
        @Max(value = 1000, message = "Os pontos da copa não podem ser maiores que 1000") Integer cupPoints) {
}
