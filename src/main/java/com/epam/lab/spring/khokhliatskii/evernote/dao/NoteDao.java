package com.epam.lab.spring.khokhliatskii.evernote.dao;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<Note, Integer> {

    @Nullable
    Note findOneByName(String name);

    @Nullable
    Note findOne(int id);
}
