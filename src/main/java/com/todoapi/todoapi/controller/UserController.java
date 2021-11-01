package com.todoapi.todoapi.controller;

import com.todoapi.todoapi.model.User;
import com.todoapi.todoapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<User> saveNewUEntity(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/validUser")
    public ResponseEntity<Boolean> validUser(@RequestParam String email, @RequestParam String password) {
        boolean isValid = userService.validUser(email, password);
        HttpStatus status = (isValid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(isValid);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getEmail());
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updadeUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

}