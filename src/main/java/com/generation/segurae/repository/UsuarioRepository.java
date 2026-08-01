package com.generation.segurae.repository;

import com.generation.segurae.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContainingIgnoreCase(String nome);

}
