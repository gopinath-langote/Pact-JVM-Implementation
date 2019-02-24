package com.vodqa.pact.userservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user")
    public User getUser() {
        return new User("gopi", "gopinath@gmail.com");
    }
}
