package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;

import java.util.List;

public interface NoteService {

    Note get(String name);

    List<Note> getAll();

    Note save(Note note);

    void delete(Note note);

    Note findById(int id);

    boolean isExists(String name);


}
