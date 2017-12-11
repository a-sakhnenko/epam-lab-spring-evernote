package com.epam.lab.spring.khokhliatskii.evernote.service;

import com.epam.lab.spring.khokhliatskii.evernote.TestConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;

import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;

import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import com.epam.lab.spring.khokhliatskii.evernote.util.TestEntityBuilder;
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
@ContextConfiguration(classes = TestConfig.class)
public class NotebookServiceTest {

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    //@Ignore
    public void createNotebook() throws Exception {
        User user = new User();
        user.setEmail("First@User.com");
        user.setPassword("1");
        userService.save(user);

        Notebook notebook = new Notebook();
        notebook.setName("First Test Notebook");
        notebook.setUser(user);
        notebookService.save(notebook);

        assertNotNull(notebookService.getAll());
    }

    @After
    public void tearDown() throws Exception {
    }

}