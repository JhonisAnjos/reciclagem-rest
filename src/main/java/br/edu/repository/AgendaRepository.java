package br.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{

	@Query("select a from Agenda a "
			+ "join a.empresa e "
			+ "join a.bairro b "
			+ "where e.id=:empresaId and b.id=:bairroId")
	public List<Agenda> findAgendaByEmpresaIdAndBairroId(
			@Param("empresaId")Integer empresaId,
			@Param("bairroId")Integer bairroId);
	
}
