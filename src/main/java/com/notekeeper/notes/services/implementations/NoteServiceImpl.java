package com.notekeeper.notes.services.implementations;

import com.notekeeper.notes.models.Note;
import com.notekeeper.notes.repositories.INoteRepository;
import com.notekeeper.notes.services.interfaces.INoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements INoteService {
    private INoteRepository noteRepository;

    public NoteServiceImpl(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findNoteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        return noteOptional.orElse(null);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
