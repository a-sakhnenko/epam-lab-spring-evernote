package com.epam.lab.spring.khokhliatskii.evernote.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @ManyToMany
    Set<Note> notes = new HashSet<Note>();
}
