package com.epam.lab.spring.khokhliatskii.evernote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"user", "notes"})
@ToString(exclude = {"user", "notes"})
@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "notebook",
            fetch = FetchType.LAZY)
    private Set<Note> notes = new HashSet<>();
}
