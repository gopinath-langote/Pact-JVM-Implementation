package com.oneexperience.pactjvm.userservice.controller;

import com.oneexperience.pactjvm.userservice.model.User;
import com.oneexperience.pactjvm.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "dynamic")
    public void saveUser(@RequestBody @Valid User user) {
        userRepository.save(user);
    }

    @GetMapping(value = "/static")
    public User getUserStatic() {
        return new User("id", "bob", "me@gmail.com");
    }

    @GetMapping(value = "/dynamic/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id) {
        User user = userRepository.get(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).build();
    }
}
