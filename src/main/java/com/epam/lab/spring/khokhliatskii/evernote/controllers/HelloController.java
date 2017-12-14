package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("message", "Hello!");
        return "hello";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/another")
    public String another(Model model) {
        model.addAttribute("message", "Hello another!");
        return "another";
    }
}
