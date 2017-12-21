package com.epam.lab.spring.khokhliatskii.evernote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String name;

    private String body;

    @ManyToOne
    @JoinColumn(name = "notebook_id",
            referencedColumnName = "id",
            nullable = false)
    private Notebook notebook;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "notes_tags",
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
