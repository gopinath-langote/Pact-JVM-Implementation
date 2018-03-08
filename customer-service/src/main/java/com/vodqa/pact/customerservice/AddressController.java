package com.vodqa.pact.customerservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @RequestMapping(value = "/address")
    public Address getCustomer() {
        return new Address("Shastri Nagar", 22, "Pune", 411014);
    }
}
