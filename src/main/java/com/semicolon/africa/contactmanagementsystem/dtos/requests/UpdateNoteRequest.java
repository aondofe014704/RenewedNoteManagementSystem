package com.semicolon.africa.contactmanagementsystem.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNoteRequest {
        private String id;
        private String newTitle;
        private String newContent;
}
