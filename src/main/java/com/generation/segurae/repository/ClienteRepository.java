package com.generation.segurae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.segurae.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findAllByNomeCompletoContainingIgnoreCase(String nomeCompleto);

}