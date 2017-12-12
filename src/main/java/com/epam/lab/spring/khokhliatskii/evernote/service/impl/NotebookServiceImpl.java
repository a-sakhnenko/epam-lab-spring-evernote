package com.epam.lab.spring.khokhliatskii.evernote.service.impl;

import com.epam.lab.spring.khokhliatskii.evernote.dao.NotebookDao;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookDao notebookDao;

//    @Override
//    public Notebook get(String name) {
//        return notebookDao.findOneByName(name);
//    }

    @Override
    public List<Notebook> getAll() {
        return notebookDao.findAll();
    }

    @Override
    public Notebook save(Notebook notebook) {

        // checks if this user already has notebook with such name.
        // throws RuntimeException if yes.
        notebook.getUser().getNotebooks().forEach(
                existingNotebook -> {
                    if (notebook.getName().equals(existingNotebook.getName())) {
                        throw new RuntimeException("User already has a notebook with such name.");
                    }
                }
        );

        return notebookDao.save(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        notebookDao.delete(notebook);
    }

    @Override
    public Notebook findById(int id) {
        return notebookDao.findById(id).get();
    }

    @Override
    public boolean isExists(String name) {
        return notebookDao.findOneByName(name) != null;
    }

}
