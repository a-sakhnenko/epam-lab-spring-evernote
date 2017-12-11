package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.TestConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

//@ContextConfiguration(classes = AppConfig.class, locations = "classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
//    @Ignore
    public void createUser() throws Exception {
        User user = new User();
        user.setEmail("First@User.com");
        user.setPassword("1");
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