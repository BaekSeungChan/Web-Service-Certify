package com.example.webservicecertify.Cookie.model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto_Cookie {
    private String id;
    private String name;
    private String password;
}
