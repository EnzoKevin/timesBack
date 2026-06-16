package com.fatec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatec.dtos.TeamDTO;
import com.fatec.dtos.TeamRequest;

@Service
public class TeamService {

    private final AtomicLong nextId = new AtomicLong(9);
    private final List<TeamDTO> teams = new ArrayList<>(List.of(
            new TeamDTO(6L, "asdas", "Angola", "2026-06-11", 10, 10, 5, 35),
            new TeamDTO(7L, "Fatec Stars", "Armenia", "2026-06-17", 10, 15, 5, 35),
            new TeamDTO(8L, "trelo", "Albania", "2026-06-16", 1, 3, 4, 7)
    ));

    public List<TeamDTO> findAll() {
        return new ArrayList<>(teams);
    }

    public TeamDTO findById(Long id) {
        return teams.stream()
                .filter(team -> team.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Team not found"));
    }

    public TeamDTO save(TeamRequest request) {
        TeamDTO team = new TeamDTO(
                nextId.getAndIncrement(),
                request.name(),
                request.country(),
                request.matchDay(),
                request.wins(),
                request.losses(),
                request.draws(),
                request.cupPoints());
        teams.add(team);
        return team;
    }

    public TeamDTO update(Long id, TeamRequest request) {
        TeamDTO existing = findById(id);
        TeamDTO updated = new TeamDTO(
                existing.id(),
                request.name(),
                request.country(),
                request.matchDay(),
                request.wins(),
                request.losses(),
                request.draws(),
                request.cupPoints());
        teams.remove(existing);
        teams.add(updated);
        return updated;
    }

    public void deleteById(Long id) {
        TeamDTO existing = findById(id);
        teams.remove(existing);
    }
}
