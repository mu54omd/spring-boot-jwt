package com.musashi.spring_boot_jwt.model;

import java.time.Instant;

public class NoteResponse {
    private String id;
    private String title;
    private String content;
    private long color;
    private Instant createdAt;

    public NoteResponse() {}

    public NoteResponse(String id, String title, String content, long color, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.color = color;
        this.createdAt = createdAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NoteResponse{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", color=" + color +
                ", createdAt=" + createdAt +
                ", id='" + id + '\'' +
                '}';
    }
}
