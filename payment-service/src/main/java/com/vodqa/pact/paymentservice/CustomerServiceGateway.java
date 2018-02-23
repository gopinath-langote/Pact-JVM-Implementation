package com.vodqa.pact.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceGateway {
    private final String customerServiceHost;
    private final String customerServicePort;
    private RestTemplate restTemplate;

    @Autowired
    public CustomerServiceGateway(RestTemplate restTemplate,
                                  @Value("${CUSTOMER_SERVICE_HOST}") String customerServiceHost,
                                  @Value("${CUSTOMER_SERVICE_PORT}") String customerServicePort) {
        this.restTemplate = restTemplate;
        this.customerServiceHost = customerServiceHost;
        this.customerServicePort = customerServicePort;
    }

    public Customer getCustomer() {
        String url = "http://" + customerServiceHost + ":" + customerServicePort + "/customer";
        return restTemplate.getForEntity(url, Customer.class).getBody();
    }

}
