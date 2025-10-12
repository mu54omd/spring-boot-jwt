package com.musashi.spring_boot_jwt.model;

import jakarta.validation.constraints.NotBlank;

public class NoteRequest {
    private String id;
    @NotBlank(message = "Title can't be blank!")
    private String title;
    private String content;
    private long color;

    public NoteRequest() {
    }

    public NoteRequest(String id, String title, String content, long color) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


