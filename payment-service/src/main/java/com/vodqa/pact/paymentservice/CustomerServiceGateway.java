package com.vodqa.pact.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CustomerServiceGateway {
    private RestTemplate restTemplate;
    private final String customerServiceHost;
    private final String customerServicePort;

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
