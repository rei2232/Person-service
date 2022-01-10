package com.example.firstexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    private static final String PATH = "/error";

    @GetMapping(value=PATH)
    public ResponseEntity error() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
