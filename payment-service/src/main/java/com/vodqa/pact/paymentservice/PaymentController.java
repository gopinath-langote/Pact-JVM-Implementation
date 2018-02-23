package com.vodqa.pact.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/payment")
public class PaymentController {
    private CustomerServiceGateway customerServiceGateway;

    @Autowired
    public PaymentController(CustomerServiceGateway customerServiceGateway) {
        this.customerServiceGateway = customerServiceGateway;
    }

    @RequestMapping
    public Payment payment() {
        Customer customer = customerServiceGateway.getCustomer();
        return new Payment(1L, 100L, customer);
    }
}
