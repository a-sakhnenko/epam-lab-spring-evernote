package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.dto.NotebookDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.UserService;
import com.epam.lab.spring.khokhliatskii.evernote.transformer.NotebookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        Notebook notebook = notebookService.findById(id);
        model.addAttribute("notebook", notebook);

        return "notebook";
    }

    //FIXME: rewrite as POST
    @RequestMapping(method = RequestMethod.GET, value = "/new/{name}")
    public String saveNotebook(Model model, @PathVariable(name = "name") String name) {
        Notebook notebook = new Notebook();
        notebook.setName(name);
        notebook.setUser(notebookService.getAll().get(0).getUser());
//        notebook.setUser(USER_FROM_SECURITY);
        notebookService.save(notebook);
        return "redirect:/notebooks";
    }
}