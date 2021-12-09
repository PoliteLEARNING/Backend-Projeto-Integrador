package br.com.politelearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politelearning.model.PLTemaModel;

public interface PLTemaRepository extends JpaRepository<PLTemaModel, Long> {
	
	public List<PLTemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);

}
