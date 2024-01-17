package com.example.webservicecertify;

import com.example.webservicecertify.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class WebServiceCertifyApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate(){
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 923);

        var expireAt = LocalDateTime.now().plusMinutes(10);

        var jwtToken = jwtService.create(claims, expireAt);

        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation(){
        var token = " eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcwNTQ4NzU0NX0.GgPXatb8zaAvpcCiBUrVXVaFXJ_eSW2wE8L7CIHnKAw";
        jwtService.validation(token);
    }

}
