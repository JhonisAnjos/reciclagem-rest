package br.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.domain.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{
	
}
