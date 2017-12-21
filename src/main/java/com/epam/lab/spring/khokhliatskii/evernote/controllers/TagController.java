package com.epam.lab.spring.khokhliatskii.evernote.controllers;

import com.epam.lab.spring.khokhliatskii.evernote.aop.LogPerformance;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Integer saveTagAndGetId(@RequestBody @Valid Tag tag, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Tag has " + bindingResult.getFieldErrorCount() + " validation counts");
        }
        return tagService.save(tag).getId();
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTag(@PathVariable String tagName) {
        tagService.delete(tagService.get(tagName));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{tagName}",
            method = RequestMethod.GET)
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Note> getNotesByTag(@PathVariable String tagName) {
        return new ArrayList<>(tagService.get(tagName).getNotes());
    }
}
