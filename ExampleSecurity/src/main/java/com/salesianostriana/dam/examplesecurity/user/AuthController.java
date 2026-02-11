package com.salesianostriana.dam.examplesecurity.user;

import com.salesianostriana.dam.examplesecurity.jwt.JwtAccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtAccessTokenService jwtAccessTokenService;
    private final AuthenticationManager authenticationManager;


    @PostMapping ("/new")
    public ResponseEntity<LoginResponse>doLogin (@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.password(),loginRequest.username()
                )
        );
        String token = jwtAccessTokenService.generateAccessToken(loginRequest.username());
        return  ResponseEntity.status(201).body(
                new LoginResponse(loginRequest.username(),token)
        );

    }
}
