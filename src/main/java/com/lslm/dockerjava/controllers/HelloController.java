package com.lslm.dockerjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {
    record  Hello(String message, String system) {}

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Hello> hello() {
        return new ResponseEntity<>(new Hello("Hello!!", System.getProperty("os.name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User createdUser = userRepository.save(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> find() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.CREATED);
    }
}
