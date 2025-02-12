package com.soffytec.eventos.repository;

import com.soffytec.eventos.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
