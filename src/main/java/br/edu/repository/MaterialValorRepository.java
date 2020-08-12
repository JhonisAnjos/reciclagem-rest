package br.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.domain.MaterialValor;

@Repository
public interface MaterialValorRepository extends JpaRepository<MaterialValor, Integer> {
	
	@Query("select mv from MaterialValor mv join mv.empresa e where e.id =:empresaId")
	public List<MaterialValor> findMaterialValorByEmpresaId(@Param("empresaId")Integer empresaId);
}
