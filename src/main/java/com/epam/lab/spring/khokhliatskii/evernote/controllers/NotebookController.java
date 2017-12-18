package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.model.Notebook;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/notebooks")
public class NotebookController {

    private static final int FIRST_USER_ID = 1;

    @Autowired
    private NotebookService notebookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotebooks(Model model) {
        List<Notebook> notebooks = notebookService.getAll(FIRST_USER_ID);
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