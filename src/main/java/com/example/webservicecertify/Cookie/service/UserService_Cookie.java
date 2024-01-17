package com.example.webservicecertify.Cookie.service;

import com.example.webservicecertify.Cookie.db.UserRepository_Cookie;
import com.example.webservicecertify.Cookie.model.LoginRequest_Cookie;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService_Cookie {

    private final UserRepository_Cookie userRepositoryCookie;
    public void login(LoginRequest_Cookie loginRequestCookie, HttpServletResponse httpServletResponse){
        var id = loginRequestCookie.getId();
        var pw = loginRequestCookie.getPassword();

        var optionalUser = userRepositoryCookie.findByName(id);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)){
                //cookie 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost"); // naver.com, daum.net, dev.xxx.com, << production.xxx.com
                cookie.setPath("/");
                cookie.setMaxAge(-1); // session;

                httpServletResponse.addCookie(cookie);
            }

        } else {
            throw new RuntimeException("User Not Found");
        }
    }

}
