package com.fatec.mappers;

import com.fatec.dtos.TicketDTO;
import com.fatec.dtos.TicketRequest;
import com.fatec.entities.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDTO toDTO(Ticket ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getMatchId(),
                ticket.getMatchDate(),
                ticket.getMatchOpponent(),
                ticket.getMatchVenue(),
                ticket.getName(),
                ticket.getCpf(),
                ticket.getPhone(),
                ticket.getSeatType()
        );
    }

    public Ticket toEntity(TicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setMatchId(request.matchId());
        ticket.setMatchDate(request.matchDate());
        ticket.setMatchOpponent(request.matchOpponent());
        ticket.setMatchVenue(request.matchVenue());
        ticket.setName(request.name());
        ticket.setCpf(request.cpf());
        ticket.setPhone(request.phone());
        ticket.setSeatType(request.seatType());
        return ticket;
    }
}