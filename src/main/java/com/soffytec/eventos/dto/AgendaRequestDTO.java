package com.soffytec.eventos.dto;

import java.time.LocalDate;

public class AgendaRequestDTO {

    private LocalDate dataEscolhida;

    private Integer quantidadeVagas;

    private Integer vagasDisponiveis;

    // Getters e Setters
    public LocalDate getDataEscolhida() {
        return dataEscolhida;
    }

    public void setDataEscolhida(LocalDate dataEscolhida) {
        this.dataEscolhida = dataEscolhida;
    }

    public Integer getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(Integer quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public Integer getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(Integer vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
}
