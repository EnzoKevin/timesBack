package com.fatec.mappers;

import com.fatec.dtos.MatchDTO;
import com.fatec.dtos.MatchRequest;
import com.fatec.entities.Match;

public class MatchMapper {

    public static Match toEntity(MatchRequest request) {
        Match match = new Match();
        match.setDate(request.date());
        match.setOpponent(request.opponent());
        match.setVenue(request.venue());
        match.setCountry(request.country());
        return match;
    }

    public static MatchDTO toDTO(Match match) {
        return new MatchDTO(
                match.getId(),
                match.getDate(),
                match.getOpponent(),
                match.getVenue(),
                match.getCountry());
    }
}
