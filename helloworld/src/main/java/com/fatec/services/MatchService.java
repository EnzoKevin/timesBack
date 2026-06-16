package com.fatec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.fatec.dtos.MatchDTO;
import com.fatec.dtos.MatchRequest;

@Service
public class MatchService {

    private final AtomicLong nextId = new AtomicLong(6);
    private final List<MatchDTO> matches = new ArrayList<>(List.of(
            new MatchDTO(1L, "2026-07-08", "Academia FC", "Estádio Municipal", "Brasil"),
            new MatchDTO(2L, "2026-07-10", "Campus Eagles", "Arena Itaim", "Argentina"),
            new MatchDTO(3L, "2026-07-12", "University United", "Campo Verde", "Portugal"),
            new MatchDTO(4L, "2026-06-17", "Campus Eagles", "Arena Itaim", "Bahrain"),
            new MatchDTO(5L, "2026-06-09", "asdas vs asdas", "itaim", "Angola / Angola")
    ));

    public List<MatchDTO> findAll() {
        return new ArrayList<>(matches);
    }

    public MatchDTO findById(Long id) {
        return matches.stream()
                .filter(match -> match.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));
    }

    public MatchDTO save(MatchRequest request) {
        MatchDTO match = new MatchDTO(
                nextId.getAndIncrement(),
                request.date(),
                request.opponent(),
                request.venue(),
                request.country());
        matches.add(match);
        return match;
    }

    public MatchDTO update(Long id, MatchRequest request) {
        MatchDTO existing = findById(id);
        MatchDTO updated = new MatchDTO(
                existing.id(),
                request.date(),
                request.opponent(),
                request.venue(),
                request.country());
        matches.remove(existing);
        matches.add(updated);
        return updated;
    }

    public void deleteById(Long id) {
        MatchDTO existing = findById(id);
        matches.remove(existing);
    }
}
