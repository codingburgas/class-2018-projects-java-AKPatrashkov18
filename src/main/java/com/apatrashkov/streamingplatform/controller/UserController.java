package com.apatrashkov.streamingplatform.controller;

import com.apatrashkov.streamingplatform.model.User;
import com.apatrashkov.streamingplatform.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> GetOne(@PathVariable Long id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> Create(@RequestBody User newUser){
        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
