package com.generation.segurae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.segurae.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public List<Cliente> findAllByNomeCompletoContainingIgnoreCase(String nomeCompleto);
	
}
