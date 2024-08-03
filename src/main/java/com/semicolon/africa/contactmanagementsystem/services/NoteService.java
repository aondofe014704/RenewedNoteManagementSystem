package com.semicolon.africa.contactmanagementsystem.services;

import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.UpdateNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.AddNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.DeleteNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.UpdateNoteResponse;

public interface NoteService {

    AddNoteResponse addNote(AddNoteRequest addNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    DeleteNoteResponse deleteNote(String noteId);
    Long getTotalNotes();
}
