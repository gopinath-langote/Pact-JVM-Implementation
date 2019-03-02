package com.vodqa.pact.userservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/api/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return new User(id, "bob", "me@gmail.com");
    }
}
