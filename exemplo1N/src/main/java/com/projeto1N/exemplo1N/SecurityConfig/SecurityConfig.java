package com.projeto1N.exemplo1N.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projeto1N.exemplo1N.Service.CustomUserDetailsService;

public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/usuarioCTR/formCadastrarUsuario",
                                "/usuarioCTR/login",
                                "/usuarioCTR/salvarUsuario",
                                "/usuarioCTR/listarUsuarios")
                        .permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/usuarioCTR/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/usuarioCTR/listarUsuarios", true)
                        .permitAll())
                .userDetailsService(userDetailsService)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

}
