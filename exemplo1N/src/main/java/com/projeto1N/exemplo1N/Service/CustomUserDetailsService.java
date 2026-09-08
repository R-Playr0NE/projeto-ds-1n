package com.projeto1N.exemplo1N.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Usuario;
import com.projeto1N.exemplo1N.Repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository oUsuarioRepository;

    public CustomUserDetailsService(UsuarioRepository oUsuarioRepository) {
        this.oUsuarioRepository = oUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario oUsuario = oUsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado!"));

        return User.builder()
                .username(oUsuario.getUsername())
                .password(oUsuario.getPassword())
                .roles(oUsuario.getRole().replace("ROLE_", ""))
                .build();
    }

}
// Essa classe vai fazer com que implementemos métodos, especificament usando o
// conceito de erança, reutilizando métodos ja existentes.