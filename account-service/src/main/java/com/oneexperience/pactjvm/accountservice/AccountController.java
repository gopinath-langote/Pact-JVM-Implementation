package com.oneexperience.pactjvm.accountservice;

import com.oneexperience.pactjvm.accountservice.model.Account;
import com.oneexperience.pactjvm.accountservice.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private UserServiceGateway userServiceGateway;

    public AccountController(UserServiceGateway userServiceGateway) {
        this.userServiceGateway = userServiceGateway;
    }

    @RequestMapping(value = "/api/account/{id}/statement")
    public Account getUser(@PathVariable("id") String id) throws Exception {
        User user = userServiceGateway.getuser(id);
        return new Account(id, 100L, user);
    }
}

