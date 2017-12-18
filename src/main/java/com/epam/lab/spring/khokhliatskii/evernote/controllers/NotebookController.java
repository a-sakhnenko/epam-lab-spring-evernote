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

    @Autowired
    private NotebookService notebookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotebooks(Model model) {
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

    @RequestMapping(method = RequestMethod.POST)
    public String saveNotebook(Model model) {

        return "redirect:/notebooks";
    }



}