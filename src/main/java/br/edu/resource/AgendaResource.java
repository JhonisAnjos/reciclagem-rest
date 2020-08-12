package br.edu.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.domain.Agenda;
import br.edu.dto.AgendaDTO;
import br.edu.dto.AgendaNewDTO;
import br.edu.service.AgendaService;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaResource {
	
	@Autowired
	private AgendaService agendaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AgendaNewDTO objDTO){
		Agenda obj = agendaService.fromDTO(objDTO);
		obj= agendaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAgendaByEmpresaIdAndBairroId(
			@RequestParam(value = "empresaId")Integer empresaId,
			@RequestParam(value = "bairroId")Integer bairroId) {
		List<Agenda> list = this.agendaService.findAgendaByEmpresaIdAndBairroId(empresaId, bairroId);
		List<AgendaDTO> dtoList = this.agendaService.getDTOList(list);
 		return ResponseEntity.ok().body(dtoList);
	}
	
	@RequestMapping(value = "/empresa/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAgendaByEmpresaId(@PathVariable
			Integer id) {
		List<Agenda> list = this.agendaService.findAgendaByEmpresaId(id);
		List<AgendaDTO> dtoList = this.agendaService.getDTOList(list);
		return ResponseEntity.ok().body(dtoList);
	}

}
