package com.epam.lab.spring.khokhliatskii.evernote.service.impl;

import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void userDaoTestOne() throws Exception {
        System.out.println();
        List<User> users = userService.getAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}