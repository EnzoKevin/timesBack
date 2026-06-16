package com.fatec.dtos;

public record TeamDTO(
        Long id,
        String name,
        String country,
        String matchDay,
        Integer wins,
        Integer losses,
        Integer draws,
        Integer cupPoints) {
}
