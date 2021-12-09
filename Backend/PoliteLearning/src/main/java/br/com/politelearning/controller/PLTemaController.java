package br.com.politelearning.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.politelearning.model.PLTemaModel;
import br.com.politelearning.repository.PLTemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PLTemaController {
	
	@Autowired
	private PLTemaRepository plTemaRepository;
	
	@GetMapping
	public ResponseEntity<List<PLTemaModel>> getAll(){
		return ResponseEntity.ok(plTemaRepository.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PLTemaModel> getById(@PathVariable long id) {
		return plTemaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<PLTemaModel> postPLTemaModel(@Valid @RequestBody PLTemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(plTemaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<PLTemaModel> putPLTemaModel(@Valid @RequestBody PLTemaModel tema) {
		return ResponseEntity.ok(plTemaRepository.save(tema));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRepository(@PathVariable long id) {
		return plTemaRepository.findById(id)
				.map(resposta -> {
					plTemaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
