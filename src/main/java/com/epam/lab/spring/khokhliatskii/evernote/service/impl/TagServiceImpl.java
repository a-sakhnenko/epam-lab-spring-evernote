package com.epam.lab.spring.khokhliatskii.evernote.service.impl;

import com.epam.lab.spring.khokhliatskii.evernote.aop.LogPerformance;
import com.epam.lab.spring.khokhliatskii.evernote.dao.TagDao;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Tag findById(int id) {
        return tagDao.findById(id).get();
    }

    @LogPerformance
    @Override
    public Tag get(String name) {
        return tagDao.findOneByName(name);
    }

    @Override
    public List<Tag> getAll() {
        return tagDao.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        if (isExists(tag.getName())) {
            Tag existingTag = get(tag.getName());

            Set<Note> notes = new HashSet<>();
            notes.addAll(existingTag.getNotes());
            notes.addAll(tag.getNotes());
            existingTag.setNotes(notes);

            return tagDao.save(existingTag);
        }

        return tagDao.save(tag);
    }

    @Override
    public void delete(Tag tag) {
        tagDao.delete(tag);
    }

    @Override
    public boolean isExists(String name) {
        return tagDao.findOneByName(name) != null;
    }
}
