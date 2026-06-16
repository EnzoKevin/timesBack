package com.fatec.dtos;

public record MatchDTO(
        Long id,
        String date,
        String opponent,
        String venue,
        String country) {
}
