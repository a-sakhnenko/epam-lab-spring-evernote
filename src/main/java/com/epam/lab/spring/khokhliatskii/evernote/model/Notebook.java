package com.epam.lab.spring.khokhliatskii.evernote.model;

import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Notebook {
    int id;
    String name;
    User user;
    @OneToMany(mappedBy = "notebook")
    Set<Note> notes = new HashSet<Note>();
}
