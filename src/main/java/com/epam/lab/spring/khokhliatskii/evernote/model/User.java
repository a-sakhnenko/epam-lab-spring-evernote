package com.epam.lab.spring.khokhliatskii.evernote.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    String email;
    String password;
    Set<Tag> tags = new HashSet<>();
    Set<Notebook> notebooks = new HashSet<>();
}
