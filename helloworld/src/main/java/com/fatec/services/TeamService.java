package com.fatec.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fatec.dtos.TeamDTO;
import com.fatec.dtos.TeamRequest;
import com.fatec.entities.Team;
import com.fatec.repositories.TeamRepository;

@Service
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public List<TeamDTO> findAll() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TeamDTO findById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
    }

    public TeamDTO save(TeamRequest request) {
        Team team = new Team(null, request.name(), request.country(), 
                             request.wins(), request.losses(), request.draws(), request.cupPoints());
        return mapToDTO(repository.save(team));
    }

    public TeamDTO update(Long id, TeamRequest request) {
        Team team = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        
        team.setName(request.name());
        team.setCountry(request.country());
        team.setWins(request.wins());
        team.setLosses(request.losses());
        team.setDraws(request.draws());
        team.setCupPoints(request.cupPoints());
        
        return mapToDTO(repository.save(team));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
        }
        repository.deleteById(id);
    }

    private TeamDTO mapToDTO(Team team) {
        return new TeamDTO(team.getId(), team.getName(), team.getCountry(),
                           team.getWins(), team.getLosses(), team.getDraws(), team.getCupPoints());
    }
}
