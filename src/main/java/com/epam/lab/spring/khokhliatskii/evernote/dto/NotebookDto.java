package com.epam.lab.spring.khokhliatskii.evernote.dto;

import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class NotebookDto {

    private int id;

    @NotNull
    private String name;

    @NotNull
    private int userId;

    private List<Note> notes = new ArrayList<>();

}



