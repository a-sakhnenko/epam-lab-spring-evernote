package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/notes")
public class NoteController {

    private static final int FIRST_USER_ID = 1;

    @Autowired
    private NoteService noteService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotebooks(Model model) {
        List<Note> notes = noteService.getAll();
        model.addAttribute("notes", notes);

        return "notes";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getNotebook(Model model, @PathVariable(name = "id") int id) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);

        return "note";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveNotebook(Model model) {

        return "redirect:/notes";
    }



}