package br.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Agenda;
import br.edu.domain.Bairro;
import br.edu.domain.Empresa;
import br.edu.dto.AgendaDTO;
import br.edu.dto.AgendaNewDTO;
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
	
	public List<Agenda> findAgendaByEmpresaIdAndBairroId(Integer empresaId, Integer bairroId) {
		return this.agendaRepository.findAgendaByEmpresaIdAndBairroId(empresaId, bairroId);
	}
	
	public List<Agenda> findAgendaByEmpresaId(Integer empresaId){
		return this.agendaRepository.findAgendaByEmpresaId(empresaId);
	}
	
	public AgendaDTO getDTO(Agenda obj) {
		return new AgendaDTO(obj.getId() ,obj.getDiaSemana(), obj.getHorario(), obj.getBairro().getNome());
	}
	
	public List<AgendaDTO> getDTOList(List<Agenda> list){
		List<AgendaDTO> dtoList = new ArrayList<AgendaDTO>();
		list.forEach(a-> dtoList.add(this.getDTO(a)));
		return dtoList;
	}
	
	public void delete(Integer id) {
		this.agendaRepository.deleteById(id);
	}

}
