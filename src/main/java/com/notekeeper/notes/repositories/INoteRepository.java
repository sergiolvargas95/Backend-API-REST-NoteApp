package com.notekeeper.notes.repositories;

import com.notekeeper.notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {
    List<Note> id(Long id);
}
