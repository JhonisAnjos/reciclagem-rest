package br.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query("select e from Empresa e where e.email = :email and e.senha = :senha")
	public Empresa findEmpresaByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

	@Query("select e from Empresa e where e.id IN( select e.id from Agenda a "
			+ "JOIN a.bairro b "
			+ "JOIN a.empresa e "
			+ "where b.id =:bairroId) ")
	public List<Empresa> findEmpresaByBairroId(@Param("bairroId") Integer bairroId);

}
