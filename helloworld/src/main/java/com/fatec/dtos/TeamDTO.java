package com.fatec.dtos;

public record TeamDTO(
        Long id,
        String name,
        String country,
        Integer wins,
        Integer losses,
        Integer draws,
        Integer cupPoints) {
}
