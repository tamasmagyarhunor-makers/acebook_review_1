package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String content;
    private Boolean friendsOnly;
    private LocalDateTime dateTime;

    public Post() {};

    public Post(String userId, String content, Boolean friendsOnly, LocalDateTime dateTime) {
        this.userId = userId;
        this.content = content;
        this.friendsOnly = friendsOnly;
        this.dateTime = dateTime;
    }

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}

    public String getUserId() {return this.userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getContent() {return this.content;}

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getFriendsOnly() {return this.friendsOnly;}

    public void setFriendsOnly(Boolean friendsOnly) {this.friendsOnly = friendsOnly;}

    public LocalDateTime getDateTime() {return this.dateTime;}

    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}
}
