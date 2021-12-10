package br.com.politelearning.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class PLUsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@NotBlank
	@Size(min = 3, max = 50, message= "")
	private String nome_completo;
	
	@NotBlank
	@Email //Verifica se o campo possui as características de um endereço de e-mail.
	@Size(min = 3, max = 50, message = "")
	private String email;
	
	@NotNull
	@Size(min = 6, max = 8, message = "" )
	private String senha;
	
	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<PLPostagem> postagem;
	
}
