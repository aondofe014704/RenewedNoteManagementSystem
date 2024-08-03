package com.semicolon.africa.contactmanagementsystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserResponse {
    private String email;
    private String password;
    private boolean isLoggedIn;

}
