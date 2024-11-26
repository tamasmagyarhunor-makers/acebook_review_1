package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Setter
//@NoArgsConstructor
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

}
