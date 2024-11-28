package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.makersacademy.acebook.dto.CommentId;

@Entity
@Table(name = "COMMENTS")
@IdClass(CommentId.class)
public class Comment {
    @Id
    @JoinColumn(name = "user_id")
    private String userId;

    @Id
    @JoinColumn(name = "post_Id")
    private Long postId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Comment(String userId, Long postId, String comments, LocalDateTime timestamp) {
        this.userId = userId;
        this.postId = postId;
        this.comments = comments;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
