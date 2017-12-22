package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class NoteController {

    private static final int FIRST_USER_ID = 1;

    @Autowired
    private NoteService noteService;
    @Autowired
    private NotebookService notebookService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(Model model) {
        List<Note> notes = noteService.getAll();
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        //get all notes of current user
        notes = notes.stream()
                .filter(n -> n.getNotebook().getUser().getEmail().equals(email))
                .collect(Collectors.toList());

        model.addAttribute("notes", notes);
        return "notes";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/notes/{id}")
    public String getNote(Model model, @PathVariable(name = "id") int id) {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Note note = noteService.findById(id);
        if(!note.getNotebook().getUser().getEmail().equals(email)){
            throw (new RuntimeException("Access violation exception"));
        }
        model.addAttribute("note", note);

        return "note";
    }

    @RequestMapping(value = "/notebooks/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<String> saveNote(@RequestBody @Valid Note note,
                                    BindingResult bindingResult,
                                    @PathVariable(name = "id") int id) {
        //get logged in username
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Notebook notebook = notebookService.findById(id);
        if(!notebook.getUser().getEmail().equals(email)){
            throw (new RuntimeException("Access violation exception"));
        }
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Notebook has " + bindingResult.getFieldErrorCount() + " validation errors");
        }

        note.setNotebook(notebook);
        noteService.save(note);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //TODO: pass dtos to controller methods, not entities
}