package com.vieira.springmongo.controllers;

import com.vieira.springmongo.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User U1 = new User("1", "Carlos", "carlos@gmail.com");
        User U2 = new User("2", "Maria", "maria@gmail.com");

        return ResponseEntity.status(HttpStatus.CREATED).body(Arrays.asList(U1, U2));
    }
}
