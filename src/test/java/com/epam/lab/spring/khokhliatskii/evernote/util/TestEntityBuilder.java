package com.epam.lab.spring.khokhliatskii.evernote.util;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestEntityBuilder {

    private User user;

    @PostConstruct
    public void init() {
        user = new User();
        user.setEmail("First@User.com");
        user.setPassword("1");
        user.setId(0);
        user.setNotebooks(initNotebooks());
        user.getNotebooks().forEach(notebook -> notebook.setUser(user));
    }

    public User getUser() {
        return user;
    }

    private Set<Notebook> initNotebooks() {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(initNotebook());
        return notebooks;
    }

    private Notebook initNotebook() {
        Notebook notebook = new Notebook();
        notebook.setId(0);
        notebook.setName("Notebook1");
        notebook.setNotes(initNotes());
        notebook.getNotes().forEach(note -> note.setNotebook(notebook));
        return notebook;
    }

    private Set<Note> initNotes() {
        Set<Note> notes = new HashSet<>();
        notes.add(initNote());
        notes.add(initNote());
        return notes;
    }

    private Note initNote() {
        Note note = new Note();
        note.setName("Note1");
        note.setId(0);
        note.setTags(initTags());
        note.getTags().forEach(tag -> tag.getNotes().add(note));
        return note;
    }

    private Set<Tag> initTags() {
        Set<Tag> tags = new HashSet<>();
        tags.add(initTag());
        return tags;
    }

    private Tag initTag() {
        Tag tag = new Tag();
        tag.setId(0);
        tag.setName("Tag1");
        tag.setNotes(new HashSet<>());
        return tag;
    }

}
