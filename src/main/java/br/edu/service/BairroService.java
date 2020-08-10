package br.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Bairro;
import br.edu.repository.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository bairroRepository;
	
	public List<Bairro> findAllBairros(){
		return this.bairroRepository.findAll();
	}

}
