package com.musashi.spring_boot_jwt.controller;

import com.musashi.spring_boot_jwt.model.Note;
import com.musashi.spring_boot_jwt.model.NoteRequest;
import com.musashi.spring_boot_jwt.model.NoteResponse;
import com.musashi.spring_boot_jwt.service.NoteService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService theNoteService){
        this.noteService = theNoteService;
    }

    @PostMapping
    public NoteResponse save(@Valid @RequestBody NoteRequest body){
        return noteService.save(body);
    }

    @GetMapping
    public List<NoteResponse> findByOwnerId(){
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return noteService.findByOwnerId(ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        Note note = noteService.findById(new ObjectId(id));
        if(note == null){
            throw new IllegalArgumentException("Note not found!");
        }
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if(note.getOwnerId().toHexString().equals(ownerId)) {
            noteService.deleteById(id);
        }
    }
}
