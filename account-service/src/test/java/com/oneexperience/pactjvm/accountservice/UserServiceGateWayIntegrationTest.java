package com.oneexperience.pactjvm.accountservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneexperience.pactjvm.accountservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceGateWayIntegrationTest {

    private MockRestServiceServer mockRestServiceServer;
    private UserServiceGateway gateway;

    @BeforeEach
    public void setUp() throws Exception {
        mockRestServiceServer = MockRestServiceServer.createServer(new RestTemplate());

        gateway = new UserServiceGateway("http://localhost:8052");
    }


    @Test
    public void shouldReturnUser() throws Exception {
        String body = "{\"id\":\"1\",\"userName\":\"bob\",\"userEmailId\":\"me@gmail.com\"}";

        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("http://localhost:8052/api/user/static"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));

        User user = gateway.getStaticUser();

        User expectedUser = new User("1", "bob", "me@gmail.com");
        System.out.println(new ObjectMapper().writeValueAsString(expectedUser));
        assertThat(user).isEqualTo(expectedUser);
    }
}
