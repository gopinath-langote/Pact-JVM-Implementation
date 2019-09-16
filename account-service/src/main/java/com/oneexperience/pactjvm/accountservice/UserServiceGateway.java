package com.oneexperience.pactjvm.accountservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneexperience.pactjvm.accountservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class UserServiceGateway {
    private final String userServiceBaseUrl;
    private final ObjectMapper objectMapper;
    private RestTemplate restTemplate;

    @Autowired
    public UserServiceGateway(
            RestTemplate restTemplate,
            ObjectMapper objectMapper,
            @Value("${USER_SERVICE_BASE_URL}") String userServiceBaseUrl
    ) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.userServiceBaseUrl = userServiceBaseUrl;
    }

    public User getStaticUser() throws IOException {
        String url = userServiceBaseUrl + "/api/user/static";
        String jsonResponse = restTemplate.getForEntity(url, String.class).getBody();
        return objectMapper.readValue(jsonResponse, User.class);
    }
}
