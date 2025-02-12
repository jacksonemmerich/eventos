package com.soffytec.eventos.repository;

import com.soffytec.eventos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
