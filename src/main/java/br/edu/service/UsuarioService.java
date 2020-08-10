package br.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.domain.Bairro;
import br.edu.domain.Usuario;
import br.edu.dto.UsuarioNewDTO;
import br.edu.repository.BairroRepository;
import br.edu.repository.UsuarioRepository;
import br.edu.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BairroRepository bairroRepository;

	public Usuario insert(Usuario obj) {
		this.usuarioRepository.save(obj);
		return obj;
	}

	public Usuario fromDTO(UsuarioNewDTO dto) {
		Optional<Bairro> bairro = this.bairroRepository.findById(dto.getBairro());
		if (bairro.isPresent()) {
			return new Usuario(dto.getNome(), dto.getCpf(), dto.getEmail(), bairro.get(), dto.getSenha());
		} else {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + dto.getBairro() + ", Tipo: " + Bairro.class.getName());
		}
	}

	public Usuario findUsuarioByEmailAndSenha(String email, String senha) {
		Optional<Usuario> obj = Optional.ofNullable(this.usuarioRepository.findUsuarioByEmailAndSenha(email, senha));
		return obj.orElseThrow(()-> new ObjectNotFoundException("E-mail e/ou senha inválidos! "));
	}

}
