package com.fatec.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TicketRequest(
        @NotNull(message = "O ID da partida não pode ser nulo")
        @Positive(message = "O ID da partida deve ser maior que zero") Long matchId,
        @NotBlank(message = "A data da partida não pode ser em branco")
        @Size(min = 5, max = 50, message = "A data da partida deve ter entre 5 e 50 caracteres") String matchDate,
        @NotBlank(message = "O adversário não pode ser em branco")
        @Size(min = 3, max = 100, message = "O adversário deve ter entre 3 e 100 caracteres") String matchOpponent,
        @NotBlank(message = "O local da partida não pode ser em branco")
        @Size(min = 3, max = 100, message = "O local da partida deve ter entre 3 e 100 caracteres") String matchVenue,
        @NotBlank(message = "O nome do titular não pode ser em branco")
        @Size(min = 3, max = 100, message = "O nome do titular deve ter entre 3 e 100 caracteres") String name,
        @NotBlank(message = "O CPF não pode ser em branco")
        @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 caracteres") String cpf,
        @NotBlank(message = "O telefone não pode ser em branco")
        @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres") String phone,
        @NotBlank(message = "O tipo de assento não pode ser em branco")
        @Size(min = 3, max = 50, message = "O tipo de assento deve ter entre 3 e 50 caracteres") String seatType) {
}
