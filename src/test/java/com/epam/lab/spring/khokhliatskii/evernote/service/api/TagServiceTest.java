package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.TestConfig;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
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

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TagServiceTest {

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Autowired
    private TagService tagService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void createTag() throws Exception {
        Tag tag = new Tag();
        tag.setName("First Test Tag");
        tagService.save(tag);
        assertNotNull(tagService.getAll());
    }

    @After
    public void tearDown() throws Exception {
    }

}