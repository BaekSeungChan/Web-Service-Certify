package com.example.webservicecertify.Cookie.controller;

import com.example.webservicecertify.Cookie.model.LoginRequest_Cookie;
import com.example.webservicecertify.Cookie.service.UserService_Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController_Cookie {

    private final UserService_Cookie userServiceCookie;

    @PostMapping("/login/cookie")
    public void login(@RequestBody LoginRequest_Cookie loginRequestCookie, HttpServletResponse httpServletResponse){
        userServiceCookie.login(loginRequestCookie, httpServletResponse);
    }

}
