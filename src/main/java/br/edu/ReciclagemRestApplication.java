package br.edu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.domain.Bairro;
import br.edu.domain.Material;
import br.edu.repository.BairroRepository;
import br.edu.repository.MaterialRepository;

@SpringBootApplication
public class ReciclagemRestApplication implements CommandLineRunner {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private BairroRepository bairroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReciclagemRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Material papel = new Material("papel");
		Material plastico = new Material("plástico");
		Material ferro = new Material("ferro");
		
		this.materialRepository.saveAll(Arrays.asList(papel, plastico, ferro));
		
		
		Bairro pituba = new Bairro("Pituba");
		Bairro barris = new Bairro("Barris");
		Bairro cajazeiras = new Bairro("Cajazeiras");
		
		this.bairroRepository.saveAll(Arrays.asList(pituba, barris, cajazeiras));
		
	}

}
