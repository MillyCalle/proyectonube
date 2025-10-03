package com.example.proyectonube.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Usuarios en memoria para pruebas
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("usuario")
                .password("{noop}1234") // {noop} = sin encriptar
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    // Configuración de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/welcome").authenticated() // requiere login
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")       // usamos login personalizado
                .permitAll()
                .defaultSuccessUrl("/welcome", true) // redirige tras login
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
