package com.generation.segurae.controller;

import com.generation.segurae.model.Usuario;
import com.generation.segurae.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                // se encontrou, devolve 200 OK com a categoria no corpo
                .map(ResponseEntity::ok)
                // se não encontrou, devolve 404 Not Found (corpo vazio)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Usuario>> getByTipo(@PathVariable String nome) {
        return ResponseEntity.ok(usuarioRepository.findByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuarios) {
        usuarios.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.save(usuarios));
    }

    @PutMapping
    public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario usuarios) {
        return usuarioRepository.findById(usuarios.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(usuarioRepository.save(usuarios)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Usuario> tema = usuarioRepository.findById(id);
        if (tema.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        usuarioRepository.deleteById(id);
    }
}
