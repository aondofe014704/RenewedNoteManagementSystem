package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.data.repository.NoteRepository;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.UpdateNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.AddNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.DeleteNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.UpdateNoteResponse;
import com.semicolon.africa.contactmanagementsystem.exception.TitleAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class NoteServiceTest {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;
    @Test
    public void testToAddNote(){
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setTitle("TestAgainAgain title");
        addNoteRequest.setContent("Test content");
        addNoteRequest.setDescription("Test description");
        AddNoteResponse addNoteResponse = noteService.addNote(addNoteRequest);
        assertThat(addNoteResponse).isNotNull();
        assertThat(addNoteResponse.getNoteId()).isNotNull();
        assertThat(noteService.getTotalNotes()).isEqualTo(1L);
    }
    @Test
    public void testAddNoteWithSameTitle_ThrowsException(){
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setTitle("TestAgainAgain title");
        addNoteRequest.setContent("Test Content");
        addNoteRequest.setDescription("Test description");
        assertThrows(TitleAlreadyExistsException.class, ()-> noteService.addNote(addNoteRequest));
    }
    @Test
    public void testToUpdateAnExistingNote(){
        UpdateNoteRequest updateNoteRequest = new UpdateNoteRequest();
        updateNoteRequest.setNewTitle("updated Title");
        updateNoteRequest.setNewContent("updated content");
        updateNoteRequest.setId("66adb438f507b074ee38b91c");
        UpdateNoteResponse updateNoteResponse = noteService.updateNote(updateNoteRequest);
        assertThat(updateNoteResponse.getNoteTitle().contains(("updated Title Successfully")));
        assertThat(updateNoteResponse.getNoteId()).isEqualTo(updateNoteResponse.getNoteId());
    }
    @Test
    public void testToDeleteNote(){
    String noteId = "66adb438f507b074ee38b91c";
    DeleteNoteResponse deleteNoteResponse =  noteService.deleteNote(noteId);
    assertThat(deleteNoteResponse.getMessage().contains("deleted"));
    }
}