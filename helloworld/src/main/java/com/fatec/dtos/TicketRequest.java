package com.fatec.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TicketRequest(
        @NotNull Long matchId,
        @NotBlank String matchDate,
        @NotBlank String matchOpponent,
        @NotBlank String matchVenue,
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank String phone,
        @NotBlank String seatType) {
}
