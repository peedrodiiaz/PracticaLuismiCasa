package com.salesianostriana.dam.examplesecurity.user;

public record LoginResponse(
        String username,
        String accessToken
) {
}
