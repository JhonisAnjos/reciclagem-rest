package br.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Empresa;
import br.edu.domain.Material;
import br.edu.domain.MaterialValor;
import br.edu.dto.MaterialValorDTO;
import br.edu.dto.MaterialValorNewDTO;
import br.edu.repository.EmpresaRepository;
import br.edu.repository.MaterialRepository;
import br.edu.repository.MaterialValorRepository;
import br.edu.service.exception.ObjectNotFoundException;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private MaterialValorRepository materialValorRepository;

	public List<Material> findAll() {
		return this.materialRepository.findAll();
	}

	public MaterialValor fromDTO(MaterialValorNewDTO dto) {
		Optional<Material> material = materialRepository.findById(dto.getMaterial());
		Optional<Empresa> empresa = empresaRepository.findById(dto.getEmpresa());
		if (material.isPresent() && empresa.isPresent()) {
			return new MaterialValor(material.get(), empresa.get(), dto.getValor());
		} else {
			throw new ObjectNotFoundException("Id da empresa e/ou Material inválido(s)");
		}
	}

	public MaterialValor insert(MaterialValor obj) {
		return materialValorRepository.save(obj);
	}

	public List<MaterialValor> findMaterialValorByEmpresaId(Integer empresaId) {
		return this.materialValorRepository.findMaterialValorByEmpresaId(empresaId);
	}

	public MaterialValorDTO getDTO(MaterialValor materialValor) {
		return new MaterialValorDTO(materialValor.getId() ,materialValor.getMaterial().getNome(), materialValor.getValor());
	}
	
	public List<MaterialValorDTO> getDTOList(List<MaterialValor> list){
		List<MaterialValorDTO> dtoList = new ArrayList<MaterialValorDTO>();
		list.forEach(m-> dtoList.add(this.getDTO(m)));
		return dtoList;
	}
	
	public void deleteMaterialValor(Integer id) {
		this.materialValorRepository.deleteById(id);
	}
}
