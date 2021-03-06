package com.epam.lab.spring.khokhliatskii.evernote.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NoteDto {

    private int id;

    @NotNull
    @Size(min = 1)
    private String name;

    private String body;

    @NotNull
    private int notebookId;

}


