package com.example.webservicecertify.Cookie.db;

import com.example.webservicecertify.Cookie.model.UserDto_Cookie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository_Cookie {

    private final List<UserDto_Cookie> userList = new ArrayList<>();

    public Optional<UserDto_Cookie> findById(String id){
        return userList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public Optional<UserDto_Cookie> findByName(String name){
        return userList
                .stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();
    }

    @PostConstruct
    public void start(){
        userList.add(
                new UserDto_Cookie(
                        UUID.randomUUID().toString(),
                        "홍길동",
                        "1234"
                )
        );

        userList.add(
                new UserDto_Cookie(
                        UUID.randomUUID().toString(),
                        "유관순",
                        "1234"
                )
        );

        userList.add(
                new UserDto_Cookie(
                        UUID.randomUUID().toString(),
                        "철수",
                        "1234"
                )
        );
    }

}
