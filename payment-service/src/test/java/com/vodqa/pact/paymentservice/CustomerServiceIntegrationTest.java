package com.vodqa.pact.paymentservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ActiveProfiles("test")
@RestClientTest(CustomerServiceGateway.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceIntegrationTest {
    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockRestServiceServer;
    private CustomerServiceGateway gateway;

    @Before
    public void setUp() throws Exception {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);

        gateway = new CustomerServiceGateway(restTemplate, "localhost", "8052");
    }


    @Test
    public void name() throws Exception {
        String body = "{\"name\":\"Gopinath\"," +
                "\"emailId\":\"gopinath@gmail.com\"}";

        mockRestServiceServer.expect(requestTo("http://localhost:8052/customer"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));

        Customer customer = gateway.getCustomer();

        Customer expectedCustomer = new Customer("Gopinath", "gopinath@gmail.com");
        assertThat(customer).isEqualTo(expectedCustomer);
    }
}
