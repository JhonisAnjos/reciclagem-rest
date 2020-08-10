package br.edu.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.domain.Usuario;
import br.edu.dto.UsuarioNewDTO;
import br.edu.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioNewDTO objDTO){
		Usuario obj = usuarioService.fromDTO(objDTO);
		obj= usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/login" , method = RequestMethod.GET)
	public ResponseEntity<Usuario> findEmpresaByEmailAndSenha(
			@RequestParam(value = "email")String email,
			@RequestParam(value = "senha")String senha) {
		Usuario obj = this.usuarioService.findUsuarioByEmailAndSenha(email, senha);
		return ResponseEntity.ok().body(obj);
	}
	


}
