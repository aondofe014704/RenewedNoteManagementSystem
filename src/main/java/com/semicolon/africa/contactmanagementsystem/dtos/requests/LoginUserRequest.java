package com.semicolon.africa.contactmanagementsystem.dtos.requests;

import com.semicolon.africa.contactmanagementsystem.exception.ContactManagementSystem;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserRequest {
    private String email;
    private String password;
}
