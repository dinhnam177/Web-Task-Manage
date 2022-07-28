package com.example.webtask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getHome() throws Exception{
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals("login", response.getBody());
    }

    @Test
    public void showLogin() throws Exception{
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/login").toString(), String.class);
        assertEquals("login", response.getBody());
    }

    @Test
    public void signUp() throws Exception{
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/signup").toString(), String.class);
        assertEquals("signup", response.getBody());
    }
}
