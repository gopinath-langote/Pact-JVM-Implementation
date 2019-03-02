package com.vodqa.pact.accountervice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class UserServiceGateway {
    private final String userServiceHost;
    private final String userServicePort;
    private RestTemplate restTemplate;

    @Autowired
    public UserServiceGateway(RestTemplate restTemplate,
                              @Value("${USER_SERVICE_HOST}") String userServiceHost,
                              @Value("${USER_SERVICE_PORT}") String userServicePort) {
        this.restTemplate = restTemplate;
        this.userServiceHost = userServiceHost;
        this.userServicePort = userServicePort;
    }

    public User getuser(String id) throws IOException {
        String url = "http://" + userServiceHost + ":" + userServicePort + "/api/user/" + id;
        String jsonResponse = restTemplate.getForEntity(url, String.class).getBody();
        return getObjectMapper().readValue(jsonResponse, User.class);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        return objectMapper;
    }
}
