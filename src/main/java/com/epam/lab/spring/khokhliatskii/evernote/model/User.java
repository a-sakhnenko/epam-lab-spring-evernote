package com.epam.lab.spring.khokhliatskii.evernote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"notebooks"})
@ToString(exclude = {"notebooks"})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();
}
