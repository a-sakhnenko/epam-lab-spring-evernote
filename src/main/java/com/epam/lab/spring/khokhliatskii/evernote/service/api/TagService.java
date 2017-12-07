package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;

import java.util.List;

public interface TagService {

    Tag findById(int id);

    Tag get(String name);

    List<Tag> getAll();

    Tag save(Tag tag);

    void delete(Tag tag);

    boolean isExists(String name);

}
