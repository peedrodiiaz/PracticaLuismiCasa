package com.salesianostriana.dam.examplesecurity.jwt;

import com.salesianostriana.dam.examplesecurity.user.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
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

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

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
                .header().setType(TOKEN_TYPE)
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

    public String getUsernameFromAccessToken(String token) {
        return jwtParser
                .parseSignedClaims(token)
                .getBody()
                .getSubject();
    }



    public boolean validateAccessToken(String token) throws  JwtException{
//        try {
//            jwtParser.parseSignedClaims(token);
//            return true;
//        } catch (JwtException ex) {
//            throw ex;
//        }
        jwtParser.parseSignedClaims(token);
        return true;
    }





}
