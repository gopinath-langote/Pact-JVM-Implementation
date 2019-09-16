package com.oneexperience.pactjvm.accountservice;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneexperience.pactjvm.accountservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "UserService")
public class UserContractTest {

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("pact.rootDir", "../Pacts");
    }

    @Pact(consumer = "AccountService")
    public RequestResponsePact createExpectations(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        DslPart body = new PactDslJsonBody()
                .stringValue("id", "1")
                .stringValue("userName", "bob")
                .stringValue("userEmailId", "me@gmail.com");

        return builder
                .uponReceiving("A request for a user")
                .path("/api/user/1")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(body)
                .toPact();

    }

    @Test
    @PactTestFor(pactMethod = "createExpectations")
    public void shouldReturnAUser(MockServer mockServer) throws IOException {
        UserServiceGateway gateway = new UserServiceGateway(new RestTemplate(), new ObjectMapper(), mockServer.getUrl());

        User user = gateway.getuser("1");

        User expectedUser =
                new User("1", "bob", "me@gmail.com");
        assertEquals(user, expectedUser);
    }
}