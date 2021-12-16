package br.com.politelearning.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.politelearning.model.UserLoginModel;
import br.com.politelearning.model.UsuarioModel;
import br.com.politelearning.repository.UsuarioRepository;

@Service // classe que vai transformar a senha em criptografia e também gerar o token
public class UsuarioService {

	
	// está injetando do repositorio
	@Autowired
	private UsuarioRepository repository;
 
	//comando para gerar a criptografia da senha
	public UsuarioModel CadastrarUsuario(UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}
     // irá acessar a senha que estará criptografada e informações de cadastro do usuário,
	// como essas informações um "token/chave de acesso" será gerada. Normalmente esse token não fica acessível para o usuário 
	public Optional<UserLoginModel> Logar(Optional<UserLoginModel> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByUsuario(user.get().getUsuario());
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				return user;
			}
		}
		return null;

	}

}