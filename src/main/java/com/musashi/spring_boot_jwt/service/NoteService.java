package com.musashi.spring_boot_jwt.service;

import com.musashi.spring_boot_jwt.database.model.Note;
import com.musashi.spring_boot_jwt.database.model.NoteRequest;
import com.musashi.spring_boot_jwt.database.model.NoteResponse;
import org.bson.types.ObjectId;

import java.util.List;


public interface NoteService {
    NoteResponse save(NoteRequest body);
    Note findById(ObjectId id);
    List<NoteResponse> findByOwnerId(String ownerId);
    void deleteById(String id);
}
