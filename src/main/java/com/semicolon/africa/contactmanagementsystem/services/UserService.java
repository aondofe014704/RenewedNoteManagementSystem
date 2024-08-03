package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.data.model.User;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.LoginUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.RegisterUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.LoginUserResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.RegisterUserResponse;

import java.util.Collection;
import java.util.List;

public interface UserService {

    RegisterUserResponse register(RegisterUserRequest registerUserRequest);

    List<User> getAllUsers();

    LoginUserResponse login(LoginUserRequest loginUserRequest);

}
