package com.vodqa.pact.paymentservice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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

    public Customer getCustomer() throws IOException {
        String url = "http://" + customerServiceHost + ":" + customerServicePort + "/customer";
        String jsonResponse = restTemplate.getForEntity(url, String.class).getBody();
        return getObjectMapper().readValue(jsonResponse, Customer.class);
    }

    public Address getAddress() throws IOException {
        String url = "http://" + customerServiceHost + ":" + customerServicePort + "/address";
        String jsonResponse = restTemplate.getForEntity(url, String.class).getBody();
        return getObjectMapper().readValue(jsonResponse, Address.class);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        return objectMapper;
    }
}
