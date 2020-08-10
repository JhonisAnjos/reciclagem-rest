package br.edu.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.domain.Empresa;
import br.edu.dto.EmpresaNewDTO;
import br.edu.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EmpresaNewDTO objDTO){
		Empresa obj = empresaService.fromDTO(objDTO);
		obj= empresaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/login" , method = RequestMethod.GET)
	public ResponseEntity<Empresa> findEmpresaByEmailAndSenha(
			@RequestParam(value = "email")String email,
			@RequestParam(value = "senha")String senha) {
		Empresa obj = this.empresaService.findEmpresaByEmailAndSenha(email, senha);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value ="/bairro" , method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> findEmpresaByBairroId(
			@RequestParam(value = "id")Integer bairroId) {
		List<Empresa> list = this.empresaService.findEmpresaByBairroId(bairroId);
		return ResponseEntity.ok().body(list);
	}

}
