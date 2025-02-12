package com.soffytec.eventos.controller;


import com.soffytec.eventos.dto.EventoRequestDTO;
import com.soffytec.eventos.entities.Evento;
import com.soffytec.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // Criar um novo evento
    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody EventoRequestDTO eventoRequestDTO) {
        Evento evento = eventoService.criarEvento(eventoRequestDTO);
        return ResponseEntity.ok(evento);
    }

    // Listar todos os eventos
    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }

    // Buscar um evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEventoPorId(@PathVariable Long id) {
        return eventoService.buscarEventoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um evento
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody EventoRequestDTO eventoRequestDTO) {
        Evento evento = eventoService.atualizarEvento(id, eventoRequestDTO);
        return ResponseEntity.ok(evento);
    }

    // Deletar um evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
