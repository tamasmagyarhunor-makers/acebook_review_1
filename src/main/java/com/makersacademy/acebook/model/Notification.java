package com.makersacademy.acebook.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "POSTS")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String content;
    private Boolean friendsOnly;
    private LocalDateTime dateTime;

    public Notification() {
    }

    public Notification(String userId, String content, Boolean friendsOnly, LocalDateTime dateTime) {
        this.userId = userId;
        this.content = content;
        this.friendsOnly = friendsOnly;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
