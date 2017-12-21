package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("message", "Welcome!");
        return "index";
    }

}
