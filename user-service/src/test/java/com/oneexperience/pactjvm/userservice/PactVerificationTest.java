package com.oneexperience.pactjvm.userservice;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneexperience.pactjvm.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Provider("UserService")
@PactFolder("../Pacts")
public class PactVerificationTest {

    @BeforeEach
    void before(PactVerificationContext context) throws Exception {
        context.setTarget(HttpTestTarget.fromUrl(new URL("http://localhost:8052")));
    }

    @State("user-1-exists")
    public void toDefaultState() throws JsonProcessingException {
        User user = new User("1", "bob", "me@gmail.com");
        String userString = new ObjectMapper().writeValueAsString(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(userString, headers);
        new RestTemplate().postForEntity("http://localhost:8052/api/user/dynamic", request, String.class);

        System.out.println("Now service in default state");
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }
}
