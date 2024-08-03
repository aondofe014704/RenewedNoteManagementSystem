package com.semicolon.africa.contactmanagementsystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
