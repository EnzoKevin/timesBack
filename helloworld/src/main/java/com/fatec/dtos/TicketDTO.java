package com.fatec.dtos;

public record TicketDTO(
        Long id,
        Long matchId,
        String matchDate,
        String matchOpponent,
        String matchVenue,
        String name,
        String cpf,
        String phone,
        String seatType) {
}
