package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.aop.LogPerformance;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.lang.management.MemoryType;
import java.util.List;

@Controller
@RequestMapping(value = "/notebooks")
public class NotebookController {

    private static final int FIRST_USER_ID = 1;

    @Autowired
    private UserService userService;

    @Autowired
    private NotebookService notebookService;

    @LogPerformance
    @RequestMapping(method = RequestMethod.GET)
    public String getNotebooks(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String email = auth.getName(); //get logged in username
//        User user = userService.get(email);
//        List<Notebook> notebooks = notebookService.getAll(user.getId());
        List<Notebook> notebooks = notebookService.getAll();
        model.addAttribute("notebooks", notebooks);

        return "notebooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getNotebook(Model model, @PathVariable(name = "id") int id) {
        Notebook notebook = notebookService.findById(id);
        model.addAttribute("notebook", notebook);

        return "notebook";
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public @ResponseBody Integer saveNotebook(@RequestBody @Valid Notebook notebook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Notebook has " + bindingResult.getFieldErrorCount() + " validation errors");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); //get logged in username
        notebook.setUser(userService.get(email));
        return notebookService.save(notebook).getId();
    }



}