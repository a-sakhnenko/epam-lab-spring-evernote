package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notebooks")
public class NotebooksController {

    @Autowired
    NotebookService notebookService;

    public String getAllnotebooks(Model model) {
        model.addAttribute("notebooks", notebookService.getAll());
        return "notebooks";
    }
}
