package com.oneexperience.pactjvm.userservice;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.URL;

@Provider("UserService")
@PactFolder("../Pacts")
public class PactVerificationTest {

    @BeforeEach
    void before(PactVerificationContext context) throws Exception {
        context.setTarget(HttpTestTarget.fromUrl(new URL("http://localhost:8052")));
        // or something like
        // context.setTarget(new HttpTestTarget("localhost", myProviderPort, "/"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }
}
