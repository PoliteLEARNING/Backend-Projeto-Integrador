package br.com.politelearning.model;

import java.util.List;

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
	@Size(min = 3, max = 50, message= "É necessário colocar o nome")
	private String nome;
	
	@NotBlank
	@Email //Verifica se o campo possui as características de um endereço de e-mail.
	@Size(min = 3, max = 50, message = "É necessário colocar um email")
	private String email;
	
	@NotNull
	@Size(min = 6, max = 8, message = "É necessario " )
	private String senha;
	
	/*@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PLPostagemModel> postagem;
		*/
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	/*
	public List<PLPostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PLPostagemModel> postagem) {
		this.postagem = postagem;
	}
 	*/	
	
	
}
