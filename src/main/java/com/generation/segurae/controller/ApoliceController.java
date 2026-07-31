package com.generation.segurae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.segurae.model.Apolice;
import com.generation.segurae.repository.ApoliceRepository;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoliceController {

	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@GetMapping
	public ResponseEntity<List<Apolice>> getAll(){
		return ResponseEntity.ok(apoliceRepository.findAll());
	}
}
