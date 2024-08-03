package com.semicolon.africa.contactmanagementsystem.web;

import com.semicolon.africa.contactmanagementsystem.dtos.requests.AddNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.requests.UpdateNoteRequest;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.AddNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.ApiResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.DeleteNoteResponse;
import com.semicolon.africa.contactmanagementsystem.dtos.responses.UpdateNoteResponse;
import com.semicolon.africa.contactmanagementsystem.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {
    private NoteService noteService;
    @PostMapping("/add-note")
    public ResponseEntity<?>  addNote (@RequestBody AddNoteRequest addNoteRequest){
        try{
            AddNoteResponse addNoteResponse = noteService.addNote(addNoteRequest);
            return new ResponseEntity<> (new ApiResponse(true, addNoteResponse), CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<> (new ApiResponse(true, exception), BAD_REQUEST);
        }
    }
    @PatchMapping("/update-note")
    public ResponseEntity<?> updateNote (@RequestBody UpdateNoteRequest updateNoteRequest){
        try {
            UpdateNoteResponse updateNoteResponse = noteService.updateNote(updateNoteRequest);
            return new ResponseEntity<> ( new ApiResponse(true, updateNoteResponse), OK);
        }
        catch (Exception exception){
            return new ResponseEntity<> (new ApiResponse(false, exception),  BAD_REQUEST);
        }
    }
        @DeleteMapping("/delete-note/{id}")
        public ResponseEntity<?> deleteNote (@PathVariable("id") String noteId){
        try {
            DeleteNoteResponse deleteNoteResponse = noteService.deleteNote(noteId);
            return new ResponseEntity<> (new ApiResponse(true, deleteNoteResponse), CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> (new ApiResponse(true, e), BAD_REQUEST);
        }
    }
}
