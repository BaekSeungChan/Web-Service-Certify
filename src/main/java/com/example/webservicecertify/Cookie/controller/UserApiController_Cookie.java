package com.example.webservicecertify.Cookie.controller;

import com.example.webservicecertify.Cookie.db.UserRepository_Cookie;
import com.example.webservicecertify.Cookie.model.UserDto_Cookie;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController_Cookie {

    private final UserRepository_Cookie userRepositoryCookie;

    @GetMapping("/me/cookie")
    public UserDto_Cookie me(HttpServletRequest httpServletRequest, @CookieValue(name = "authorization-cookie",required = false) String authorizationCookie){

        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepositoryCookie.findById(authorizationCookie);

        return optionalUserDto.get();

//        var cookies = httpServletRequest.getCookies();
//
//        if(cookies != null){
//            for(Cookie cookie : cookies){
//                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
//            }
//        }
    }
}
