package br.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{

}
