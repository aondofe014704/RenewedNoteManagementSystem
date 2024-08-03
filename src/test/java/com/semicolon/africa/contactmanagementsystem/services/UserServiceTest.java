package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.data.repository.UserRepository;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.LoginUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.RegisterUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.LoginUserResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.RegisterUserResponse;
import com.semicolon.africa.contactmanagementsystem.exception.EmailAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }
    @Test
    public void testToRegisterUser(){
        RegisterUserResponse registerUserResponse = createNewUser();
        assertThat(registerUserResponse).isNotNull();
        assertThat(userService.getAllUsers().size()).isEqualTo(1L);
    }
        private RegisterUserResponse createNewUser() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("songujack@gmail.com");
        registerUserRequest.setPassword("1234567");
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");
        return userService.register(registerUserRequest);
    }
    @Test
        public void testToRegisterUserWithSameEmail_throwException(){
        createNewUser();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("songujack@gmail.com");
        registerUserRequest.setPassword("1234567");
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");
        assertThrows(EmailAlreadyExistsException.class, ()-> userService.register(registerUserRequest));
    }
    @Test
    public void testToLoginUser(){
        createNewUser();
        LoginUserResponse loginUserResponse = loginUser();
        assertThat(loginUserResponse.isLoggedIn()).isEqualTo(true);
    }


    private LoginUserResponse loginUser() {
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("songujack@gmail.com");
        loginUserRequest.setPassword("1234567");
        return userService.login(loginUserRequest);
    }

}