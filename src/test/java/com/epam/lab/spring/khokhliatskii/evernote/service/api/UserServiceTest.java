package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.config.AppConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void createUser() throws Exception {
        User user = new User();
        user.setEmail("First@User.com");
        user.setPassword("1");
        user.setRole("ROLE_USER");
        userService.save(user);
        assertNotNull(userService.getAll());
    }

    @Test
    @Transactional
    public void getAll() {
        List<User> all = userService.getAll();
        assertNotNull(all);
        assertFalse(all.isEmpty());
    }


    @After
    public void tearDown() throws Exception {
    }

}