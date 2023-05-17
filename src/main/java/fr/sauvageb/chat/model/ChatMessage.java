package fr.sauvageb.chat.model;

import java.time.LocalDateTime;

public class ChatMessage {

    private Long id;
    private String message;
    private User sender;
    private LocalDateTime createdAt;


    public ChatMessage(Long id, String message, User sender, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public ChatMessage(String message, User sender, LocalDateTime createdAt) {
        this.message = message;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
