package com.epam.lab.spring.khokhliatskii.evernote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"notebook", "tags"})
@ToString(exclude = {"notebook", "tags"})
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String body;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Notebook notebook;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "notes_tags",
            joinColumns = @JoinColumn(
                    name = "note_id",
                    referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "id",
                    nullable = false))
    private Set<Tag> tags = new HashSet<>();
}
