package com.fatec.controllers;

import com.fatec.dtos.TicketDTO;
import com.fatec.dtos.TicketRequest;
import com.fatec.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDTO> create(@RequestBody TicketRequest request) {
        return ResponseEntity.status(201).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> update(@PathVariable Long id, @RequestBody TicketRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}