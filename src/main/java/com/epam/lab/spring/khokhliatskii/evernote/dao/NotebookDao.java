package com.epam.lab.spring.khokhliatskii.evernote.dao;


import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NotebookDao extends JpaRepository<Notebook, Integer> {


    @Nullable
    Notebook findOneByName(String name);

    Notebook findByName(String name);

    Set<Notebook> findAllByUser(User user);
}