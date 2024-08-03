package com.semicolon.africa.contactmanagementsystem.data.repository;

import com.semicolon.africa.contactmanagementsystem.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
    boolean existsByTitle(String title);
}
