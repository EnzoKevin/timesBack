package com.fatec.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MatchRequest(
        @NotBlank(message = "A data do jogo não pode ser em branco")
        @Size(min = 5, max = 50, message = "A data do jogo deve ter entre 5 e 50 caracteres") String date,
        @NotBlank(message = "O adversário não pode ser em branco")
        @Size(min = 3, max = 100, message = "O adversário deve ter entre 3 e 100 caracteres") String opponent,
        @NotBlank(message = "O local não pode ser em branco")
        @Size(min = 3, max = 100, message = "O local deve ter entre 3 e 100 caracteres") String venue,
        @NotBlank(message = "O país não pode ser em branco")
        @Size(min = 3, max = 100, message = "O país deve ter entre 3 e 100 caracteres") String country) {
}
