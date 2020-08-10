package br.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.domain.MaterialValor;

@Repository
public interface MaterialValorRepository extends JpaRepository<MaterialValor, Integer> {

}
