package com.study.study.service;

import com.study.study.data.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {
    private final List<Note> noteList = new ArrayList<>();

    public List<Note> listAll() {
        return noteList;
    }

    public Note add(Note note) {
        note.setId(new Random().nextLong());
        this.noteList.add(note);
        return note;
    }

    public void deleteById(long id) {
        for (Note note : this.noteList) {
            if (note.getId() == id) {
                noteList.remove(note);
            }
        }
    }

    public void update(Note note) {
        try {
            this.getById(note.getId()).setContent("random");
            this.getById(note.getId()).setTitle("random");
        } catch (Exception e) {
            System.out.println("Note does not exist");
        }

    }

    public Note getById(long id) {
        for (Note note : this.noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
}
