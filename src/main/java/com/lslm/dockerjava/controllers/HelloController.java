package com.lslm.dockerjava.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    record  Hello(String message, String system) {}

    @GetMapping
    public ResponseEntity<Hello> hello() {
        return new ResponseEntity<>(new Hello("Hello!!", System.getProperty("os.name")), HttpStatus.OK);
    }
}
