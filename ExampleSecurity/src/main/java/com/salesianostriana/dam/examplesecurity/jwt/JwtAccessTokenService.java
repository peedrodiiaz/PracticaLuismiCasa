package com.salesianostriana.dam.examplesecurity.jwt;

import com.salesianostriana.dam.examplesecurity.user.User;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtAccessTokenService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInSeconds;

    private JwtParser jwtParser;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {

        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        jwtParser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

    }

    public String generateAccessToken(User user) {
        return generateAccessToken(user.getUsername());
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .header().setType("JWT")
                .and()
                .subject(username)
                .issuedAt(new java.util.Date())
                .expiration(java.util.Date.from(
                        java.time.Instant.now()
                                .plusSeconds(jwtLifeInSeconds)
                ))
                .signWith(secretKey)
                .compact();
    }




}
