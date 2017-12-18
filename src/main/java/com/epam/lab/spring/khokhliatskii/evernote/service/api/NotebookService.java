package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;

import java.util.List;

public interface NotebookService {

    //Notebook get(String name);

    List<Notebook> getAll();

    List<Notebook> getAll(int userID);

    Notebook save(Notebook notebook);

    void delete(Notebook notebook);

    Notebook findById(int id);

    boolean isExists(String name);

}
