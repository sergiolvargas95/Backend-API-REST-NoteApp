package com.notekeeper.notes.controllers;

import com.notekeeper.notes.models.Note;
import com.notekeeper.notes.responses.ApiResponse;
import com.notekeeper.notes.services.implementations.NoteServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private NoteServiceImpl noteService;

    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> findNoteById(@PathVariable("id") Long id) {
        Note note = noteService.findNoteById(id);

        if(note != null) {
            return ResponseEntity.ok(new ApiResponse<>(
                    note,
                    "Note found",
                    null,
                    true
            ));
        } else {
            return new ResponseEntity<>(new ApiResponse<>(
                    null,
                    "Note not found",
                    "Doesn't exists a note with ID" + id,
                    false
            ), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        List<Note> notes = noteService.findAllNotes();
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note noteCreated = noteService.createNote(note);
        return new ResponseEntity<>(noteCreated, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note newNote) {
        Note note = noteService.findNoteById(id);

        if(note != null) {
            note.setId(id);
            Note noteUpdated = noteService.updateNote(newNote);
            return ResponseEntity.ok(noteUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        Note note = noteService.findNoteById(id);

        if(note != null) {
            noteService.deleteNoteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
