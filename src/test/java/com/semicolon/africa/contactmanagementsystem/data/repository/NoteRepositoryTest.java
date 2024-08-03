package com.semicolon.africa.contactmanagementsystem.data.repository;

import com.semicolon.africa.contactmanagementsystem.data.model.Note;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NoteRepositoryTest {
    @Autowired
    private NoteRepository noteRepository;
    @Test
    public void testToSaveNote(){
    AddNoteRequest addNoteRequest = new AddNoteRequest();
    addNoteRequest.setTitle("The footBall Title");
    addNoteRequest.setContent("The football Content");
    Note note = new Note();
    note.setTitle(addNoteRequest.getTitle());
    note.setContent(addNoteRequest.getContent());
    note.setDescription(addNoteRequest.getDescription());
    noteRepository.save(note);
    assertNotNull(note.getId());
    assertEquals(noteRepository.count(), 1);
    }

}