package com.todoapi.todoapi.controller;

import com.todoapi.todoapi.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Diego", "serra@", "12345");
        return ResponseEntity.ok().body(user);
    }
}
