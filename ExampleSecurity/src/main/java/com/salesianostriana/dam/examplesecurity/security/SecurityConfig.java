package com.salesianostriana.dam.examplesecurity.security;

import com.salesianostriana.dam.examplesecurity.error.RestControllerAdvice;
import com.salesianostriana.dam.examplesecurity.jwt.JwtAccessTokenService;
import com.salesianostriana.dam.examplesecurity.jwt.JwtAuthenticationFilter;
import com.salesianostriana.dam.examplesecurity.user.User;
import com.salesianostriana.dam.examplesecurity.user.UserRepository;
import io.jsonwebtoken.Jwt;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAccessTokenService jwtAccessTokenService;
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

              http .authorizeHttpRequests(auth -> auth
                       .requestMatchers("/error").permitAll()
                       .requestMatchers("/auth/new", "/api/users/login").permitAll()
                       .anyRequest().authenticated()
               );

       http.httpBasic(AbstractHttpConfigurer::disable)
                       .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                               .csrf(AbstractHttpConfigurer::disable);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint()
                            .accessDeniedHandler(jwtAuthenticationFilter)
                );


        return http.build();

    }
    @PostConstruct
    void init() {
        userRepository.save(User.builder()
                        .userName("admin")
                        .enabled(true)
                        .role("ADMIN")
                        .password(passwordEncoder.encode("admin"))
                .build());

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }




}
