package com.notekeeper.notes.services.interfaces;

import com.notekeeper.notes.models.Note;

import java.util.List;

public interface INoteService {
    Note findNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Note note);
    List<Note> findAllNotes();
    void deleteNoteById(Long id);
}
