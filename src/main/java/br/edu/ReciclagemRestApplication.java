package br.edu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.domain.Agenda;
import br.edu.domain.Bairro;
import br.edu.domain.Empresa;
import br.edu.domain.Material;
import br.edu.domain.MaterialValor;
import br.edu.repository.AgendaRepository;
import br.edu.repository.BairroRepository;
import br.edu.repository.EmpresaRepository;
import br.edu.repository.MaterialRepository;
import br.edu.repository.MaterialValorRepository;

@SpringBootApplication
public class ReciclagemRestApplication implements CommandLineRunner {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private MaterialValorRepository materialValorRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;

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
		
		Empresa americanas = new Empresa("Americanas", "06678965421", "americanas@americanas.com", "1234");
		Empresa extra = new Empresa("Extra", "06678965421", "extra@extra.com", "1234");
		Empresa reciclagem = new Empresa("Reciclagem", "06678965421", "americanas@americanas.com", "1234");
		
		this.empresaRepository.saveAll(Arrays.asList(americanas, extra, reciclagem));
		
		MaterialValor valorPapel = new MaterialValor(papel, reciclagem, 10.0);
		MaterialValor valorPlastico = new MaterialValor(plastico, reciclagem, 11.0);
		MaterialValor valorFerro = new MaterialValor(ferro, reciclagem, 3.0);
		
		this.materialValorRepository.saveAll(Arrays.asList(valorPapel, valorPlastico, valorFerro));
		
		Agenda a1 = new Agenda(reciclagem, pituba, 1, "9:00"); 
		Agenda a2 = new Agenda(reciclagem, pituba, 2, "9:00"); 
		Agenda a3 = new Agenda(reciclagem, pituba, 3, "10:00"); 
		Agenda a4 = new Agenda(reciclagem, pituba, 3, "17:00"); 
		Agenda a5 = new Agenda(reciclagem, pituba, 7, "8:00"); 
		
		this.agendaRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));
		
		
	}
	

}
