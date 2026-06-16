package com.fatec.dtos;

import jakarta.validation.constraints.NotBlank;

public record MatchRequest(
        @NotBlank String date,
        @NotBlank String opponent,
        @NotBlank String venue,
        @NotBlank String country) {
}
