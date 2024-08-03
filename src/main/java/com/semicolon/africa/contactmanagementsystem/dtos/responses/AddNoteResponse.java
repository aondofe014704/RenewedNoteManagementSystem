package com.semicolon.africa.contactmanagementsystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddNoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteContent;
    private LocalDateTime dateCreated;
}
