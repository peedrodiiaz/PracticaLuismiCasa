package com.salesianostriana.dam.examplesecurity.user;

public record LoginRequest(
        String username,
        String password
) {
}
