package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.data.model.User;
import com.semicolon.africa.contactmanagementsystem.data.repository.UserRepository;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.LoginUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.RegisterUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.LoginUserResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.RegisterUserResponse;
import com.semicolon.africa.contactmanagementsystem.exception.EmailAlreadyExistsException;
import com.semicolon.africa.contactmanagementsystem.exception.UserLoginExceptinon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.contactmanagementsystem.utils.Mapper.map;
import static com.semicolon.africa.contactmanagementsystem.utils.Mapper.mapUserLogin;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{
    private final UserRepository userRepository;
    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        validateEmail(registerUserRequest.getEmail());
        User user = new User();
        map(registerUserRequest, user);
        userRepository.save(user);
        return map(user);
    }
    private void validateEmail(String email){
        boolean existsByEmail = userRepository.existsByEmail(email);
        if(existsByEmail) throw new EmailAlreadyExistsException(email + "Email already exists");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByEmail(loginUserRequest.getEmail());
        validateEmail(loginUserRequest.getEmail());
        user.setLoggedIn(true);
        userRepository.save(user);
        return mapUserLogin(user);
    }
    private void validateUserLogin(User user) {
        if(!user.isLoggedIn()) throw new UserLoginExceptinon("You must be logged in");
    }
}
