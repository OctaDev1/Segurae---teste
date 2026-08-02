package com.generation.segurae.security;

import com.generation.segurae.model.Usuario;
import com.generation.segurae.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

//Terminada
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.trim().isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        if (usuario.isPresent()){
            return new UserDetailsImp(usuario.get());
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }

}