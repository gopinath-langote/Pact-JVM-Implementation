package com.oneexperience.pactjvm.accountservice;

import com.oneexperience.pactjvm.accountservice.model.Account;
import com.oneexperience.pactjvm.accountservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private UserServiceGateway userServiceGateway;

    public AccountController(UserServiceGateway userServiceGateway) {
        this.userServiceGateway = userServiceGateway;
    }

    @GetMapping(value = "/dynamic/{id}/statement")
    public Account getAccountBalance(@PathVariable("id") String id) throws Exception {
        User user = userServiceGateway.getDynamicUser(id);
        return new Account(id, 100L, user);
    }

    @GetMapping(value = "/static/statement")
    public Account getStaticBalance() throws Exception {
        User user = userServiceGateway.getStaticUser();
        return new Account("id", 100L, user);
    }
}

