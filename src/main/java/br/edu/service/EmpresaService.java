package br.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Empresa;
import br.edu.dto.EmpresaNewDTO;
import br.edu.repository.EmpresaRepository;
import br.edu.service.exception.ObjectNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public Empresa fromDTO(EmpresaNewDTO dto) {
		return new Empresa(dto.getNome(), dto.getCnpj(), dto.getEmail(), dto.getSenha());
	}

	public Empresa insert(Empresa empresa) {
		this.repository.save(empresa);
		return empresa;
	}

	public Empresa findEmpresaByEmailAndSenha(String email, String senha) {
		Optional<Empresa> obj = Optional.ofNullable(this.repository.findEmpresaByEmailAndSenha(email, senha));
		return obj.orElseThrow(()-> new ObjectNotFoundException("E-mail e/ou senha inválidos! "));
	}
	
	public List<Empresa> findEmpresaByBairroId(Integer bairroId){
		return this.repository.findEmpresaByBairroId(bairroId);
	}

}
