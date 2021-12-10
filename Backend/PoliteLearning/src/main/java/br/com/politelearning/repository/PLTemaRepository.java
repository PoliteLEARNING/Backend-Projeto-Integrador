package br.com.politelearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.politelearning.model.PLTemaModel;

@Repository
public interface PLTemaRepository extends JpaRepository<PLTemaModel, Long> {
	
	public List<PLTemaModel> findAllByNomeContainingIgnoreCase(String nome);

}
