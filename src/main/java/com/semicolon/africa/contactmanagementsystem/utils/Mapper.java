package com.semicolon.africa.contactmanagementsystem.utils;

import com.semicolon.africa.contactmanagementsystem.data.model.Note;
import com.semicolon.africa.contactmanagementsystem.data.model.User;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.RegisterUserRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.AddNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.LoginUserResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.RegisterUserResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.UpdateNoteResponse;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;

public class Mapper {
    public static void map(AddNoteRequest addNoteRequest, Note note){
    note.setTitle(addNoteRequest.getTitle());
    note.setContent(addNoteRequest.getContent());
    note.setCreatedAt(LocalDateTime.now());
    }
    public static AddNoteResponse map(Note note){
        AddNoteResponse addNoteResponse = new AddNoteResponse();
        addNoteResponse.setNoteId(note.getId());
        addNoteResponse.setNoteTitle(note.getTitle());
        addNoteResponse.setNoteContent(note.getContent());
        addNoteResponse.setDateCreated(LocalDateTime.now());
        return addNoteResponse;
    }
    public static UpdateNoteResponse mapUpdatedNote(Note note){
        UpdateNoteResponse updateNoteResponse = new UpdateNoteResponse();
        updateNoteResponse.setNoteId(note.getId());
        updateNoteResponse.setNoteTitle(note.getTitle());
        updateNoteResponse.setNoteContent(note.getContent());
        updateNoteResponse.setCreatedAt(LocalDateTime.now());
        return updateNoteResponse;
    }
    public static void map(RegisterUserRequest registerUserRequest, User user){
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
    }
    public static RegisterUserResponse map(User user){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        user.setId(registerUserResponse.getId());
        user.setEmail(registerUserResponse.getEmail());
        return registerUserResponse;
    }
    public static LoginUserResponse mapUserLogin(User user){
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        user.setPassword(loginUserResponse.getPassword());
        user.setEmail(loginUserResponse.getEmail());
        return loginUserResponse;
    }


}