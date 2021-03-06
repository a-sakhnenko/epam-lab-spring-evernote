package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.config.AppConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void createNote() throws Exception {

        User user = new User();
        user.setEmail("First@User.com");
        user.setPassword("1");
        user.setRole("ROLE_USER");
        userService.save(user);

        Notebook notebook = new Notebook();
        notebook.setName("First Test Notebook");
        notebook.setUser(user);

        notebookService.save(notebook);

        Note note = new Note();
        note.setName("First Test Note");
        note.setBody("gfdsgsdfhdtfhxdfghdtfghdfghdfghdfgh");
        note.setNotebook(notebook);
        noteService.save(note);
        assertNotNull(noteService.getAll());
    }



    @After
    public void tearDown() throws Exception {
    }

}