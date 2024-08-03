package com.semicolon.africa.contactmanagementsystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddNoteRequest {
    private String title;
    private String content;
    private String description;
}
