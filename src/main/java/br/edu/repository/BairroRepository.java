package br.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.domain.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer>{

}
