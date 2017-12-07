package com.epam.lab.spring.khokhliatskii.evernote.dao;


import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookDao extends JpaRepository<Notebook, Integer> {


}