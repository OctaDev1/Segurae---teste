package com.generation.segurae.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.segurae.model.Apolice;
import com.generation.segurae.repository.ApoliceRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoliceController {

	@Autowired
	private ApoliceRepository apoliceRepository;
	
	/* para quando tiver junto da classe Cliente
	@Autowired
	private ClienteRepository clienteRepository;
	*/
	
	@GetMapping
	public ResponseEntity<List<Apolice>> getAll(){
		return ResponseEntity.ok(apoliceRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Apolice>> getById(@PathVariable Long id){
		return ResponseEntity.ok(apoliceRepository.findById(id));
	}
	
	@GetMapping("/placa/{placa}")
	public ResponseEntity<List<Apolice>> getByPlaca(@PathVariable String placa){
		return ResponseEntity.ok(apoliceRepository.findAllByPlacaContainingIgnoreCase(placa));
	}
	
	@GetMapping("/tipoCobertura/{tipoCobertura}")
	public ResponseEntity<List<Apolice>> getByTipoCobertura(@PathVariable String tipoCobertura){
		return ResponseEntity.ok(apoliceRepository.findAllByTipoCoberturaContainingIgnoreCase(tipoCobertura));
	}
	
	/* post para quando tiver a classe Cliente junto
	@PostMapping
	public ResponseEntity<Apolice> post(@Valid @RequestBody Apolice apolice){
		if(apoliceRepository.existsById(apolice.getId())) {
			if(clienteRepository.existsById(apolice.cliente.getId())) {
				return ResponseEntity.status(HttpStatus.CREATED).body(apoliceRepository.save(apolice));
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este cliente não existe ou não está cadastrado.");
		}
	}
	*/
	
	@PostMapping
	public ResponseEntity<Apolice> post(@Valid @RequestBody Apolice apolice){
			return ResponseEntity.status(HttpStatus.CREATED).body(apoliceRepository.save(apolice));
	}
	
	/* put para quando estiver junto da classe cliente
	@PutMapping
	public ResponseEntity<Apolice> put(@Valid @RequestBody Apolice apolice){
		if(apoliceRepository.existsById(apolice.getId())) {
			if(clienteRepository.existsById(apolice.getCliente().getId())) {
				return ResponseEntity.ok(apoliceRepository.save(apolice));
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este cliente não está cadastrado (não existe no banco de dados).", null);
		}
		return ResponseEntity.notFound().build();
	} 
	 */
	
	@PutMapping
	public ResponseEntity<Apolice> put(@Valid @RequestBody Apolice apolice){
		if(apoliceRepository.existsById(apolice.getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(apoliceRepository.save(apolice));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta apólice não está cadastrada (não existe no banco de dados).", null);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Apolice> apolice = apoliceRepository.findById(id);
		
		if(apolice.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		apoliceRepository.deleteById(id);
	}
}
