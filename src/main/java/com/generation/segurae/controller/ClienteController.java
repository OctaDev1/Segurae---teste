package com.generation.segurae.controller;

import java.util.List;

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

import com.generation.segurae.model.Cliente;
import com.generation.segurae.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nomeCompleto}")
	public ResponseEntity<List<Cliente>> getByNomeCompleto(@PathVariable String nomeCompleto) {
		return ResponseEntity.ok(clienteRepository.findAllByNomeCompletoContainingIgnoreCase(nomeCompleto));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> post(@Valid @RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> put(@Valid @RequestBody Cliente cliente) {
		if (clienteRepository.existsById(cliente.getId())) {
			return ResponseEntity.ok(clienteRepository.save(cliente));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(resposta -> {
					clienteRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}