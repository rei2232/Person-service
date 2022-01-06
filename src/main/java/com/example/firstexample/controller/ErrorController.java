package com.example.firstexample.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    private static final String PATH = "/error";

    @GetMapping(value=PATH)
    public String error() {
        return "error";
    }
}
