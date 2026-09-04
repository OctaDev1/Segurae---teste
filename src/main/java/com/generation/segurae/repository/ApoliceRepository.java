package com.generation.segurae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.segurae.model.Apolice;

public interface ApoliceRepository extends JpaRepository<Apolice, Long>{
	
	public List<Apolice> findAllByTipoCoberturaContainingIgnoreCase(String tipoCobertura);
	public List<Apolice> findAllByPlacaContainingIgnoreCase(String placa);

}
