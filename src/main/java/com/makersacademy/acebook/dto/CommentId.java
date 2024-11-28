package com.makersacademy.acebook.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CommentId {
    @Column(name = "user_id", insertable=false, updatable=false)
    private String userId;

    @Column(name = "post_id", insertable=false, updatable=false)
    private Long postId;

    public CommentId(String userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }
    public CommentId() {}
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

}
