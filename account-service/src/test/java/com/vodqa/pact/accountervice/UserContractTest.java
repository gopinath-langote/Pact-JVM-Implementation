package com.vodqa.pact.accountervice;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.vodqa.pact.accountervice.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserContractTest {
    @Before
    public void setUp() throws Exception {
        System.setProperty("pact.rootDir", "../Pacts");
    }

    @Rule
    public PactProviderRuleMk2 mockServer = new PactProviderRuleMk2("UserService", this);

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
    @PactVerification
    public void shouldReturnAUser() throws IOException {
        UserServiceGateway gateway = new UserServiceGateway(new RestTemplate(),
                mockServer.getConfig().getHostname(), mockServer.getPort().toString());

        User user = gateway.getuser("1");

        User expectedUser =
                new User("1", "bob", "me@gmail.com");
        assertEquals(user, expectedUser);
    }
}
