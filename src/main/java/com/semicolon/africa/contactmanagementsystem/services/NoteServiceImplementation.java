package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.data.model.Note;
import com.semicolon.africa.contactmanagementsystem.data.repository.NoteRepository;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.UpdateNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.AddNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.DeleteNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.UpdateNoteResponse;
import com.semicolon.africa.contactmanagementsystem.exception.NoteNotFoundException;
import com.semicolon.africa.contactmanagementsystem.exception.TitleAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.semicolon.africa.contactmanagementsystem.utils.Mapper.map;
import static com.semicolon.africa.contactmanagementsystem.utils.Mapper.mapUpdatedNote;

@Service
public class NoteServiceImplementation implements NoteService {
    @Autowired
    private NoteRepository noteRepository;


    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        validateTitle(addNoteRequest.getTitle());
        Note note = new Note();
        map(addNoteRequest, note);
        note = noteRepository.save(note);
        return map(note);
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest) {
        Note note = findById(updateNoteRequest.getId());
        note.setTitle(updateNoteRequest.getNewTitle());
        note.setContent(updateNoteRequest.getNewContent());
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return mapUpdatedNote(note);
    }

    @Override
    public DeleteNoteResponse deleteNote(String noteId) {
        Note note = findById(noteId);
        noteRepository.delete(note);
        DeleteNoteResponse deleteNoteResponse = new DeleteNoteResponse();
        deleteNoteResponse.setMessage("Successfully deleted");
        return deleteNoteResponse;
    }

    private Note findById(String id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));
    }

    private void validateTitle(String title){
        boolean existsByTitle = noteRepository.existsByTitle(title);
        if(existsByTitle) throw new TitleAlreadyExistsException(title + "Title already exists");
    }

    @Override
    public Long getTotalNotes() {
        return noteRepository.count();
    }
}
