package br.com.politelearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politelearning.model.PLPostagemModel;

public interface PLPostagemRepository extends JpaRepository<PLPostagemModel, Long>{
	
	public List<PLPostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
	
}
