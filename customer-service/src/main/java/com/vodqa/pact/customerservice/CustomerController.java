package com.vodqa.pact.customerservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/customer")
public class CustomerController {

    @RequestMapping
    public Customer getCustomer() {
        return new Customer("gopi", "gopinath@gmail.com");
    }
}
