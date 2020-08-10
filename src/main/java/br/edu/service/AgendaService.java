package br.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Agenda;
import br.edu.domain.Bairro;
import br.edu.domain.Empresa;
import br.edu.domain.Material;
import br.edu.domain.MaterialValor;
import br.edu.dto.AgendaNewDTO;
import br.edu.dto.MaterialValorNewDTO;
import br.edu.repository.AgendaRepository;
import br.edu.repository.BairroRepository;
import br.edu.repository.EmpresaRepository;
import br.edu.service.exception.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	

	public Agenda fromDTO(AgendaNewDTO dto) {
		Optional<Bairro> bairro = bairroRepository.findById(dto.getBairro());
		Optional<Empresa> empresa = empresaRepository.findById(dto.getEmpresa());
		if (bairro.isPresent() && empresa.isPresent()) {
			return new Agenda(empresa.get(), bairro.get(), dto.getDiaSemana(), dto.getHorario());
		} else {
			throw new ObjectNotFoundException("Id da empresa e/ou Bairro inválido(s)");
		}

	}
	
	public Agenda insert(Agenda agenda) {
		this.agendaRepository.save(agenda);
		return agenda;
	}

}
