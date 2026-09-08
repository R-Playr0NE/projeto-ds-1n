package com.projeto1N.exemplo1N.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeansConfig {

    @Bean // Serve para construir e executar métodos proprios de classes dele mesmo,
          // utilizadas dentro do proprio springboot, nela é tratada a criptografia da
          // senha.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
