package com.fatec.mappers;

import com.fatec.dtos.TeamDTO;
import com.fatec.dtos.TeamRequest;
import com.fatec.entities.Team;

public class TeamMapper {

    public static Team toEntity(TeamRequest request) {
        Team team = new Team();
        team.setName(request.name());
        team.setCountry(request.country());
        team.setMatchDay(request.matchDay());
        team.setWins(request.wins());
        team.setLosses(request.losses());
        team.setDraws(request.draws());
        team.setCupPoints(request.cupPoints());
        return team;
    }

    public static TeamDTO toDTO(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getCountry(),
                team.getMatchDay(),
                team.getWins(),
                team.getLosses(),
                team.getDraws(),
                team.getCupPoints());
    }
}
