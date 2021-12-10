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
import br.com.politelearning.model.PLPostagemModel;
import br.com.politelearning.repository.PLPostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PLPostagemController {
	
	@Autowired
	private PLPostagemRepository plPostagemRepository;
	
	@GetMapping //requisição de todas as postagens no banco de dados
	public ResponseEntity<List<PLPostagemModel>> getAll(){
		return ResponseEntity.ok(plPostagemRepository.findAll());
		
	}
	
	@GetMapping("/{id}") //requisição das postagens a partir do id
	public ResponseEntity<PLPostagemModel> getById(@PathVariable long id) {
		return plPostagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/titulo/{titulo}") //requisição das postagens a partir de um título
	public ResponseEntity<List<PLPostagemModel>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(plPostagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		
		
	}
	@PostMapping //Inserir uma nova postagem no banco de dados
	public ResponseEntity<PLPostagemModel> postPLPostagemModel(@Valid @RequestBody PLPostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(plPostagemRepository.save(postagem));
	}
	
	@PutMapping //Atualizar uma postagem
	public ResponseEntity<PLPostagemModel> putPLPostagemModel(@Valid @RequestBody PLPostagemModel postagem){
		return ResponseEntity.ok(plPostagemRepository.save(postagem));
	}
	
	@DeleteMapping("/{id}") //deletar uma postagem
	public ResponseEntity<?> deletePLPostagemModel(@PathVariable long id) {
		
		return plPostagemRepository.findById(id)
				.map(resposta -> {
						plPostagemRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
						
				})
				.orElse(ResponseEntity.notFound().build());
				}

	
}

