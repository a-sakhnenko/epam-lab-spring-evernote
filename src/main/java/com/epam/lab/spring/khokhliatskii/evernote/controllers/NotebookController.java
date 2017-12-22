package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.dto.NotebookDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import com.epam.lab.spring.khokhliatskii.evernote.transformer.NotebookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@Controller
@RequestMapping(value = "/notebooks")
public class NotebookController {

    private static final int FIRST_USER_ID = 1;

    @Autowired
    private NotebookService notebookService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotebooks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.get(name);
        List<Notebook> notebooks = notebookService.getAll(user.getId());
        model.addAttribute("notebooks", notebooks);
        return "notebooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getNotebook(Model model, @PathVariable(name = "id") int id) {
        //get logged in username
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Notebook notebook = notebookService.findById(id);
        if (!notebook.getUser().getEmail().equals(email)){
            throw (new RuntimeException("Access violation exception"));
        }
        model.addAttribute("notebook", notebook);
        return "notebook";
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<String>  saveNotebook(@RequestBody @Valid Notebook notebook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Notebook has " + bindingResult.getFieldErrorCount() + " validation errors");
        }
        //get logged in username
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        notebook.setUser(userService.get(email));
        notebookService.save(notebook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<String> updateNotebook(@RequestBody @Valid Notebook notebook,
                                          @PathVariable(name = "id") int id,
                                          BindingResult bindingResult) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Notebook notebookOld = notebookService.findById(id);
        if (!notebook.getUser().getEmail().equals(email)){
            throw (new RuntimeException("Access violation exception"));
        }
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Notebook has " + bindingResult.getFieldErrorCount() + " validation errors");
        }

        notebookOld.setNotes(notebook.getNotes());
        notebookOld.setName(notebook.getName());
        notebookService.save(notebookOld);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<String> deleteNotebook(@PathVariable(name = "id") int id,
                                          BindingResult bindingResult) {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Notebook notebook = notebookService.findById(id);
        if (!notebook.getUser().getEmail().equals(email)){
            throw (new RuntimeException("Access violation exception"));
        }
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Notebook has " + bindingResult.getFieldErrorCount() + " validation errors");
        }
        notebookService.delete(notebook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO: move logic to service as much as possible, make @transactional



}