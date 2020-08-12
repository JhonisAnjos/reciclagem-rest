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

import br.edu.domain.Material;
import br.edu.domain.MaterialValor;
import br.edu.domain.Usuario;
import br.edu.dto.MaterialValorDTO;
import br.edu.dto.MaterialValorNewDTO;
import br.edu.service.MaterialService;

@RestController
@RequestMapping(value = "/materiais")
public class MaterialResource {
	
	@Autowired
	private MaterialService materialService ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Material>> findAll() {
		List<Material> list = materialService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MaterialValorNewDTO objDTO){
		MaterialValor obj = materialService.fromDTO(objDTO);
		obj= materialService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/empresa" , method = RequestMethod.GET)
	public ResponseEntity<List<MaterialValorDTO>> findMaterialValorByEmpresaId(
			@RequestParam(value = "id")Integer id) {
		List<MaterialValor> list = this.materialService.findMaterialValorByEmpresaId(id);
		List<MaterialValorDTO> dtoList = this.materialService.getDTOList(list);
 		return ResponseEntity.ok().body(dtoList);
	}

}
