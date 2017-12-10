package com.epam.lab.spring.khokhliatskii.evernote.service;

import com.epam.lab.spring.khokhliatskii.evernote.config.AppConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void createMark() throws Exception {
        Tag tag = new Tag();
        tag.setType("Super");
        boolean operation = tagService.createMark(tag);
        System.out.println("******************");
        System.out.println(operation);

        List<Tag> tags = tagService.getAllMarks();
        for (Tag t : tags){
            System.out.println(t);
        }

    }

    @After
    public void tearDown() throws Exception {
    }

}