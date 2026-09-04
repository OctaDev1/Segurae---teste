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
import com.generation.segurae.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoliceController {

	@Autowired
	private ApoliceRepository apoliceRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Apolice>> getAll() {
		return ResponseEntity.ok(apoliceRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Apolice> getById(@PathVariable Long id) {
		Optional<Apolice> apolice = apoliceRepository.findById(id);

		if (apolice.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esta apólice não existe ou não está cadastrada.");
		}

		return ResponseEntity.ok(apolice.get());
	}

	@GetMapping("/placa/{placa}")
	public ResponseEntity<List<Apolice>> getByPlaca(@PathVariable String placa) {
		return ResponseEntity.ok(apoliceRepository.findAllByPlacaContainingIgnoreCase(placa));
	}

	@GetMapping("/tipoCobertura/{tipoCobertura}")
	public ResponseEntity<List<Apolice>> getByTipoCobertura(@PathVariable String tipoCobertura) {
		return ResponseEntity.ok(apoliceRepository.findAllByTipoCoberturaContainingIgnoreCase(tipoCobertura));
	}

	@PostMapping
	public ResponseEntity<Apolice> post(@Valid @RequestBody Apolice apolice) {
		if (apolice.getCliente() != null && clienteRepository.existsById(apolice.getCliente().getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(apoliceRepository.save(apolice));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este cliente não existe ou não está cadastrado.");
	}

	@PutMapping
	public ResponseEntity<Apolice> put(@Valid @RequestBody Apolice apolice) {
		if (apolice.getId() == null || !apoliceRepository.existsById(apolice.getId())) {
			return ResponseEntity.notFound().build();
		}

		if (apolice.getCliente() != null && clienteRepository.existsById(apolice.getCliente().getId())) {
			return ResponseEntity.ok(apoliceRepository.save(apolice));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este cliente não está cadastrado (não existe no banco de dados).");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (apoliceRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		apoliceRepository.deleteById(id);
	}
}