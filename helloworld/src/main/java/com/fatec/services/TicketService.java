package com.fatec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.fatec.dtos.TicketDTO;
import com.fatec.dtos.TicketRequest;

@Service
public class TicketService {

    private final AtomicLong nextId = new AtomicLong(3);
    private final List<TicketDTO> tickets = new ArrayList<>(List.of(
            new TicketDTO(1L, 1L, "2026-07-08", "Academia FC", "Estádio Municipal", "Enzo Kevin Morais rocha", "51925372820", "(11) 94551-1419", "vip"),
            new TicketDTO(2L, 3L, "2026-07-12", "University United", "Campo Verde", "Enzo Kevin Morais rocha", "660.430.345-49", "+551194551419 ", "lateral")
    ));

    public List<TicketDTO> findAll() {
        return new ArrayList<>(tickets);
    }

    public TicketDTO findById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
    }

    public TicketDTO save(TicketRequest request) {
        TicketDTO ticket = new TicketDTO(
                nextId.getAndIncrement(),
                request.matchId(),
                request.matchDate(),
                request.matchOpponent(),
                request.matchVenue(),
                request.name(),
                request.cpf(),
                request.phone(),
                request.seatType());
        tickets.add(ticket);
        return ticket;
    }

    public TicketDTO update(Long id, TicketRequest request) {
        TicketDTO existing = findById(id);
        TicketDTO updated = new TicketDTO(
                existing.id(),
                request.matchId(),
                request.matchDate(),
                request.matchOpponent(),
                request.matchVenue(),
                request.name(),
                request.cpf(),
                request.phone(),
                request.seatType());
        tickets.remove(existing);
        tickets.add(updated);
        return updated;
    }

    public void deleteById(Long id) {
        TicketDTO existing = findById(id);
        tickets.remove(existing);
    }
}
