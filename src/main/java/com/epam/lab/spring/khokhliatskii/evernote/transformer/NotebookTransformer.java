package com.epam.lab.spring.khokhliatskii.evernote.transformer;

import com.epam.lab.spring.khokhliatskii.evernote.dto.NotebookDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class NotebookTransformer implements Transformer<Notebook, NotebookDto> {

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private UserService userService;

    @Override
    public NotebookDto unbind(Notebook source) {
        NotebookDto notebookDto = new NotebookDto();
        notebookDto.setId(source.getId());
        notebookDto.setName(source.getName());
        notebookDto.setUserId(source.getUser().getId());
        notebookDto.setNotes(new ArrayList<>(source.getNotes()));
        return notebookDto;
    }

    @Override
    public Notebook bind(NotebookDto source) {
        Notebook notebook = notebookService.findById(source.getId());
        if (notebook == null) {
            notebook = new Notebook();
        }
        notebook.setName(source.getName());
        notebook.setUser(userService.findById(source.getUserId()));
        notebook.setNotes(new HashSet<>(source.getNotes()));
        return notebook;
    }
}
