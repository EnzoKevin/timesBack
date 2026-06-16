package com.fatec.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TBL_TICKETS")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matchId;
    private String matchDate;
    private String matchOpponent;
    private String matchVenue;
    private String name;
    private String cpf;
    private String phone;
    private String seatType;

    public Ticket() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public String getMatchDate() { return matchDate; }
    public void setMatchDate(String matchDate) { this.matchDate = matchDate; }

    public String getMatchOpponent() { return matchOpponent; }
    public void setMatchOpponent(String matchOpponent) { this.matchOpponent = matchOpponent; }

    public String getMatchVenue() { return matchVenue; }
    public void setMatchVenue(String matchVenue) { this.matchVenue = matchVenue; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}