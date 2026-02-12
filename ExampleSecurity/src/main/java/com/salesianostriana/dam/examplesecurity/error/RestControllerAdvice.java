package com.salesianostriana.dam.examplesecurity.error;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
@Component
@RequiredArgsConstructor
public class RestControllerAdvice extends ResponseEntityExceptionHandler {


    public void commence(HttpServletRequest req,
                         HttpServletResponse res,
                         AuthenticationException ex) {
        resolver.resolveException(req, res, null, ex);
    }
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;



}
