package com.soffytec.eventos.dto;

import java.util.List;

public class EventoRequestDTO {

    private String descricao;

    private List<AgendaRequestDTO> agendas;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<AgendaRequestDTO> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendaRequestDTO> agendas) {
        this.agendas = agendas;
    }
}
