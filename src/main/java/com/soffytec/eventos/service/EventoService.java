package com.soffytec.eventos.service;


import com.soffytec.eventos.dto.EventoRequestDTO;
import com.soffytec.eventos.entities.Agenda;
import com.soffytec.eventos.entities.Evento;
import com.soffytec.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Criar um novo evento
    public Evento criarEvento(EventoRequestDTO eventoRequestDTO) {
        Evento evento = new Evento();
        evento.setDescricao(eventoRequestDTO.getDescricao());

        List<Agenda> agendas = eventoRequestDTO.getAgendas().stream()
                .map(dto -> {
                    Agenda agenda = new Agenda();
                    agenda.setDataEscolhida(dto.getDataEscolhida());
                    agenda.setQuantidadeVagas(dto.getQuantidadeVagas());
                    agenda.setVagasDisponiveis(dto.getVagasDisponiveis());
                    return agenda;
                })
                .collect(Collectors.toList());

        evento.setAgendas(agendas);
        return eventoRepository.save(evento);
    }

    // Buscar todos os eventos
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    // Buscar um evento por ID
    public Optional<Evento> buscarEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }
    // Atualizar um evento
    public Evento atualizarEvento(Long id, EventoRequestDTO eventoRequestDTO) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id);
        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();
            evento.setDescricao(eventoRequestDTO.getDescricao());

            // Initialize the agendas list if null
            if (evento.getAgendas() == null) {
                evento.setAgendas(new ArrayList<>());
            }

            // Clear existing agendas
            evento.getAgendas().clear();

            // Create and add new agendas
            List<Agenda> novasAgendas = eventoRequestDTO.getAgendas().stream()
                    .map(dto -> {
                        Agenda agenda = new Agenda();
                        agenda.setDataEscolhida(dto.getDataEscolhida());
                        agenda.setQuantidadeVagas(dto.getQuantidadeVagas());
                        agenda.setVagasDisponiveis(dto.getVagasDisponiveis());
                        agenda.setEvento(evento);
                        return agenda;
                    })
                    .collect(Collectors.toList());

            evento.getAgendas().addAll(novasAgendas);
            return eventoRepository.save(evento);
        }
        throw new RuntimeException("Evento não encontrado");
    }
    // Deletar um evento
    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}