package com.vodqa.pact.accountervice;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserContractTest {
    @Rule
    public PactProviderRuleMk2 mockServer = new PactProviderRuleMk2("UserService", this);

    @Pact(consumer = "AccountService")
    public RequestResponsePact createExpectations(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        DslPart body = new PactDslJsonBody()
                .stringValue("userName", "gopi")
                .stringValue("emailId", "gopinath@gmail.com");

        return builder
                .uponReceiving("A request for a user")
                .path("/user")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(body)
                .toPact();

    }

    @Test
    @PactVerification
    public void shouldReturnAUser() throws IOException {
        UserServiceGateway gateway = new UserServiceGateway(new RestTemplate(),
                mockServer.getConfig().getHostname(), mockServer.getPort().toString());

        User user = gateway.getuser();

        User expectedUser =
                new User("gopi", "gopinath@gmail.com");
        assertEquals(user, expectedUser);
    }
}
