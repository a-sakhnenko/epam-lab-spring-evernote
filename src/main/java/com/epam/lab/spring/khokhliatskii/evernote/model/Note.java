package com.epam.lab.spring.khokhliatskii.evernote.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    String name;
    String body;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Notebook notebook;
    @ManyToMany(mappedBy = "notes")
    Set<Tag> tags = new HashSet<Tag>();
}
