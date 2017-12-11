package com.epam.lab.spring.khokhliatskii.evernote.dao;


import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookDao extends JpaRepository<Notebook, Integer> {


    @Nullable
    Notebook findOneByName(String name);

    @Nullable
    Notebook findOne(int id);

}