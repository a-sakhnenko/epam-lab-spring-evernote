package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;

import java.util.List;

public interface NotebookService {

    Notebook get(String name);

    List<Notebook> getAll();

    Notebook save(Notebook note);

    void delete(Notebook note);

    Notebook findById(int id);

    boolean isExists(String name);

}
