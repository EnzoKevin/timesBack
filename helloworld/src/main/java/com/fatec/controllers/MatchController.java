package com.fatec.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.dtos.MatchDTO;
import com.fatec.dtos.MatchRequest;
import com.fatec.services.MatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matches")
@CrossOrigin
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MatchDTO> create(@Valid @RequestBody MatchRequest request) {
        MatchDTO match = service.save(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(match.id())
                .toUri();
        return ResponseEntity.created(location).body(match);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchDTO> update(@PathVariable Long id, @Valid @RequestBody MatchRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
