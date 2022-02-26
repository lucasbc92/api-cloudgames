package org.senai.devinhouse.semana10.cloudgames.api.v1.handler;

import org.senai.devinhouse.semana10.cloudgames.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Void> entityNotFound(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
