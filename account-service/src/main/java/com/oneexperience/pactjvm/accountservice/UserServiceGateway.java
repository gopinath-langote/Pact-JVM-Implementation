package com.oneexperience.pactjvm.accountservice;

import com.fasterxml.jackson.databind.DeserializationFeature;
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

    @Autowired
    public UserServiceGateway(
            @Value("${USER_SERVICE_BASE_URL}") String userServiceBaseUrl
    ) {
        this.userServiceBaseUrl = userServiceBaseUrl;
    }

    public User getStaticUser() throws IOException {
        String url = userServiceBaseUrl + "/api/user/static";
        return getUserResourceByUrl(url);
    }

    public User getDynamicUser(String id) throws IOException {
        String url = userServiceBaseUrl + "/api/user/dynamic/" + id;
        return getUserResourceByUrl(url);
    }

    private User getUserResourceByUrl(String url) throws IOException {
        String jsonResponse = new RestTemplate().getForEntity(url, String.class).getBody();
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
