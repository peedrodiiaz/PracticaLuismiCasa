package com.salesianostriana.dam.examplesecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {


    @GetMapping ("/admin")
    public String admin (){
        return  "Hola admin";
    }
}
