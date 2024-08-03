package com.semicolon.africa.contactmanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Document("NotePort")
    public class Note {
        @Id
        private String id;
        private String content;
        private String title;
        private String description;
        private LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime updatedAt;
    }
