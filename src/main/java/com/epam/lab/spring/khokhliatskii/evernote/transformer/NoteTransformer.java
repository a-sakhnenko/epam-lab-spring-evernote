package com.epam.lab.spring.khokhliatskii.evernote.transformer;

import com.epam.lab.spring.khokhliatskii.evernote.dto.NoteDto;
import com.epam.lab.spring.khokhliatskii.evernote.model.Note;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NoteService;
import com.epam.lab.spring.khokhliatskii.evernote.service.api.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteTransformer implements Transformer<Note, NoteDto> {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NotebookService notebookService;

    @Override
    public NoteDto unbind(Note source) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(source.getId());
        noteDto.setName(source.getName());
        noteDto.setBody(source.getBody());
        noteDto.setNotebookId(source.getNotebook().getId());
        return noteDto;
    }

    @Override
    public Note bind(NoteDto source) {
        Note note = noteService.findById(source.getId());
        if (note == null) {
            note = new Note();
        }
        note.setName(source.getName());
        note.setBody(source.getBody());
        note.setNotebook(notebookService.findById(source.getId()));
        return note;
    }
}
