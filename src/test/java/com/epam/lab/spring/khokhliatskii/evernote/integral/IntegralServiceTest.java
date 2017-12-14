package com.epam.lab.spring.khokhliatskii.evernote.integral;

import com.epam.lab.spring.khokhliatskii.evernote.TestConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import com.epam.lab.spring.khokhliatskii.evernote.util.TestEntityBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class IntegralServiceTest {
    private static final String TAG_PATTERN = "Test Tag ";
    private static final String NOTE_NAME_PATTERN = "Test Note ";
    private static final String NOTE_BODY_PATTERN = "Test Note Body ";
    private static final String NOTEBOOK_NAME_PATTERN = "Test Notebook ";
    private static final String EMAIL = "test@user.nl";
    private static final String PASSWORD_PATTERN = "1";

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Autowired
    private NoteService noteService;

    @Autowired
    private TagService tagService;

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {

        for (int u = 0; u < 4; u++) {
            User user = new User();
            user.setEmail(EMAIL + u);
            user.setPassword(PASSWORD_PATTERN);
            user = userService.save(user);

            for (int i = 0; i < 3; i++) {
                Notebook notebook = new Notebook();
                notebook.setName(NOTEBOOK_NAME_PATTERN + u + " " + i);
                notebook.setUser(user);
//                Set<Notebook> notebooks = user.getNotebooks();
//                notebooks.add(notebook);
//                user.setNotebooks(notebooks);

                System.out.println();
                System.out.println("notebook from app: " + notebook
                        + "\nuser: " + notebook.getUser()
                        + "\nnotes: ");
                for (Note n : notebook.getNotes()) {
                    System.out.println(n);
                }
                System.out.println("this user has "
                        + userService.get(notebook.getUser().getEmail()).getNotebooks().size()
                        + " notebooks");


                notebook = notebookService.save(notebook);

                System.out.println();
                System.out.println("notebook from db: " + notebookService.findById(notebook.getId())
                        + "\nuser: " + notebook.getUser()
                        + "\nnotes: ");
                for (Note n : notebook.getNotes()) {
                    System.out.println(n);
                }
                System.out.println("this user has "
                        + userService.get(notebook.getUser().getEmail()).getNotebooks().size()
                        + " notebooks");


                System.out.println("User " + user.getEmail()
                        + " has " + userService.get(user.getEmail()).getNotebooks().size() + " notebooks");
            }

            for (int i = 0; i < 4; i++) {
                Tag tag = new Tag();
                tag.setName(TAG_PATTERN + i);
                tag.setUsers(Collections.singleton(user));
                tag = tagService.save(tag);
            }

            Set<Notebook> notebooks = user.getNotebooks();
            int t = 0;
            for (Notebook n : notebooks) {
                for (int i = 0; i < 5; i++, t++) {
                    Set<Tag> tags = new HashSet<>();
                    tags.add(tagService.get(TAG_PATTERN + (t % 4)));
                    tags.add(tagService.get(TAG_PATTERN + ((t + 1) % 4)));

                    Note note = new Note();
                    note.setName(NOTE_NAME_PATTERN + n.getId() + " " + i);
                    note.setBody(NOTE_BODY_PATTERN + n.getId() + " " + i);
                    note.setNotebook(n);
                    note.setTags(tags);
                    note = noteService.save(note);
                }
            }
        }
    }

    @Test
    @Transactional
//    @Ignore
    public void cascadeDeleteAllUserNotesAndNotebooks() throws Exception {
        User user = userService.get(EMAIL + 1);

        System.out.println("notebooks before user delete: " + user.getNotebooks().size());

        userService.delete(user);

        System.out.println("notebooks after user delete: " + user.getNotebooks().size());


        for (Notebook nb : notebookService.getAll()) {
            System.out.println(nb);
        }

        for (Note n : noteService.getAll()) {
            System.out.println(n);
        }

        long count = notebookService.getAll().stream()
                .filter(notebook ->
                        (notebook.getUser().getId() == user.getId()))
                .count();
        assertEquals(0, count);
    }


    @After
    public void tearDown() throws Exception {
    }

}