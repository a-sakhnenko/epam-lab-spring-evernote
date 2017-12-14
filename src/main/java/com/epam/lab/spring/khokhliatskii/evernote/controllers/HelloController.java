package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {
    public String hello(ModelMap model) {
        model.addAttribute("message", "Hello!");
        return "hello";
    }
}
