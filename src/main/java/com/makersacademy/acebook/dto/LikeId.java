package com.makersacademy.acebook.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class LikeId {
    @Column(name = "user_id", insertable=false, updatable=false)
    private String userId;
    @Column(name = "post_id", insertable=false, updatable=false)
    private Long postId;

    public LikeId(String userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public LikeId() {}

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }
}
