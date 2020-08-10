package br.edu.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.domain.Bairro;
import br.edu.service.BairroService;

@RestController
@RequestMapping(value = "/bairros")
public class BairroResource {

	@Autowired
	private BairroService bairroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bairro>> findAll() {
		List<Bairro> list = bairroService.findAllBairros();
		return ResponseEntity.ok().body(list);
	}
}
