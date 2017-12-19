package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
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

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Integer saveNote(@RequestBody @Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Note has " + bindingResult.getFieldErrorCount() + " validation errors");
        }
        return noteService.save(note).getId();
    }



}