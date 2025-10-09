package com.musashi.spring_boot_jwt.database.repository;

import com.musashi.spring_boot_jwt.database.model.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, ObjectId> {
    List<Note> findByOwnerId(ObjectId ownerId);
}
