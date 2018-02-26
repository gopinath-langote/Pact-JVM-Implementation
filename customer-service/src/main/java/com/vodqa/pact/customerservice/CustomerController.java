package com.vodqa.pact.customerservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @RequestMapping(value = "/customer")
    public Customer getCustomer() {
        return new Customer("gopi", "gopinath@gmail.com");
    }
}
