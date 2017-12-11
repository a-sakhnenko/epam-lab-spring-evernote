package com.epam.lab.spring.khokhliatskii.evernote.service.impl;

import com.epam.lab.spring.khokhliatskii.evernote.dao.NoteDao;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public Note get(String name) {
        return noteDao.findOneByName(name);
    }

    @Override
    public List<Note> getAll() {
        return noteDao.findAll();
    }

    @Override
    public Note save(Note note) {
        return noteDao.save(note);
    }

    @Override
    public void delete(Note note) {
        noteDao.delete(note);
    }

    @Override
    public Note findById(int id) {
        return noteDao.findById(id).get();
    }

    @Override
    public boolean isExists(String name) {
        return noteDao.findOneByName(name) != null;
    }

}
