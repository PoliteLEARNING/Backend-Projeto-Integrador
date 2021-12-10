package br.com.politelearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.politelearning.model.PLTemaModel;
import br.com.politelearning.model.PLUsuarioModel;

@Repository
public interface PLUsuarioRepository extends JpaRepository<PLUsuarioModel, Long> {
	
	public List<PLTemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
