package br.com.politelearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.politelearning.model.PLPostagemModel;

@Repository
public interface PLPostagemRepository extends JpaRepository<PLPostagemModel, Long>{
	
	public List<PLPostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
	
}
