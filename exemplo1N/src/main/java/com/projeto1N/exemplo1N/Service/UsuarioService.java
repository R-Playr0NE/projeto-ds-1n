package com.projeto1N.exemplo1N.Service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Usuario;
import com.projeto1N.exemplo1N.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository oUsuarioRepository;
    private PasswordEncoder oPasswordEncoder;

    public UsuarioService(UsuarioRepository oUsuarioRepository,
            PasswordEncoder oPasswordEncoder) {
        this.oUsuarioRepository = oUsuarioRepository;
        this.oPasswordEncoder = oPasswordEncoder;
    }

    public void cadastrarUsuario(Usuario oUsuario) {
        // Serve para criprtografar a senha antes de ir para o banco de dados.
        oUsuario.setPassword(
                oPasswordEncoder.encode(oUsuario.getPassword()));

        if (oUsuario.getRole() == null || oUsuario.getRole().isEmpty()) {

            oUsuario.setRole("ROLE_USER");
        }

        oUsuarioRepository.save(oUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return oUsuarioRepository.findAll();
    }

}
