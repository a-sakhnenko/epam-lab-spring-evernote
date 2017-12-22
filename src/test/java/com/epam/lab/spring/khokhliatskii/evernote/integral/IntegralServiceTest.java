package com.epam.lab.spring.khokhliatskii.evernote.integral;

import com.epam.lab.spring.khokhliatskii.evernote.config.AppConfig;
import com.epam.lab.spring.khokhliatskii.evernote.dao.NotebookDao;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class IntegralServiceTest {
    private static final String TAG_PATTERN = "Test Tag ";
    private static final String NOTE_NAME_PATTERN = "Test Note ";
    private static final String NOTE_BODY_PATTERN = "Test Note Body ";
    private static final String NOTEBOOK_NAME_PATTERN = "Test Notebook ";
    private static final String EMAIL = "test@user.";
    private static final String PASSWORD_PATTERN = "1";

    @Autowired
    private NoteService noteService;

    @Autowired
    private TagService tagService;

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private NotebookDao notebookDao;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
//
//        User user = new User();
//        user.setEmail(EMAIL + "com");
//        user.setPassword(PASSWORD_PATTERN);
//        user = userService.save(user);
//
//        Notebook notebook = new Notebook();
//        notebook.setName(NOTEBOOK_NAME_PATTERN);
//        notebook.setUser(user);
//        user.getNotebooks().add(notebook);
//        notebook = notebookService.save(notebook);
//
//        System.out.println("this user notebooks: "+ userService.get(user.getEmail()).getNotebooks());
//        System.out.println("this notebook user: "+ notebookService.findById(notebook.getId()).getUser());

//
//        for (int u = 0; u < 4; u++) {
//            User user = new User();
//            user.setEmail(EMAIL + u);
//            user.setPassword(PASSWORD_PATTERN);
//            user = userService.save(user);
//
//            for (int i = 0; i < 3; i++) {
//                Notebook notebook = new Notebook();
//                notebook.setName(NOTEBOOK_NAME_PATTERN + u + " " + i);
//                notebook.setUser(user);
//                notebook = notebookService.save(notebook);
//
//                //user.getNotebooks().add(notebook);
//            }
//            //user = userService.save(user);
//
//            for (int i = 0; i < 4; i++) {
//                Tag tag = new Tag();
//                tag.setName(TAG_PATTERN + i);
//                tag = tagService.save(tag);
//            }
//
//            user = userService.get(user.getEmail());
//            Set<Notebook> notebooks = user.getNotebooks();
//
//            int t = 0;
//            for (Notebook n : notebooks) {
//                System.out.println(" this user notebooks: " + n);
//                for (int i = 0; i < 5; i++, t++) {
//                    Set<Tag> tags = new HashSet<>();
//                    tags.add(tagService.get(TAG_PATTERN + (t % 4)));
//                    tags.add(tagService.get(TAG_PATTERN + ((t + 1) % 4)));
//
//                    Note note = new Note();
//                    note.setName(NOTE_NAME_PATTERN + n.getId() + " " + i);
//                    note.setBody(NOTE_BODY_PATTERN + n.getId() + " " + i);
//                    note.setNotebook(notebookService.findById(n.getId()));
//                    note.setTags(tags);
//                    note = noteService.save(note);
//                }
//            }
//        }
    }

    @Test
    @Transactional
//    @Ignore
    public void cascadeDeleteAllUserNotesAndNotebooks() throws Exception {
//        User user = userService.get(EMAIL + 1);
//
//        System.out.println(user);
//        System.out.println("notebooks before user delete: " + user.getNotebooks().size());
//
//        userService.delete(user);
//        System.out.println(user);
//        System.out.println("notebooks after user delete: " + user.getNotebooks().size());
//
//        System.out.println("check if user is deleted: " + userService.get(user.getEmail()));
//
//
//        for (Notebook nb : notebookService.getAll()) {
//            System.out.println(nb);
//        }
//
//        for (Note n : noteService.getAll()) {
//            System.out.println(n);
//        }
//
////        long count = notebookService.getAll().stream()
////                .filter(notebook ->
////                        (notebook.getUser().getId() == user.getId()))
////                .count();
//        int size = notebookDao.findAllByUser(user).size();
//        assertEquals(0, size);
    }


    @After
    public void tearDown() throws Exception {
    }

}