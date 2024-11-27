package com.makersacademy.acebook.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class PostWithData {
    private Long id;
    private String content;
    private String userId;
    private Boolean friendsOnly;
    private LocalDateTime dateTime;
    private String nickname;
    private boolean liked;

    public PostWithData(Long id, String content, String userId, Boolean friendsOnly, LocalDateTime dateTime, String nickname, boolean liked) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.friendsOnly = friendsOnly;
        this.dateTime = dateTime;
        this.nickname = nickname;
        this.liked = liked;
    }

    public PostWithData() {};

    public Long getId() {return this.id;}
    public String getContent() {return this.content;}
    public String getUserId() {return this.userId;}
    public Boolean getFriendsOnly() {return this.friendsOnly;}
    public LocalDateTime getDateTime() {return this.dateTime;}
    public String getNickname() {return this.nickname;}
    public boolean getLiked() {return this.liked;}

    public void setId(Long id) {this.id = id;}
    public void setContent(String content) {this.content = content;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setFriendsOnly(boolean friendsOnly) {this.friendsOnly = friendsOnly;}
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public void setLiked(boolean liked) {this.liked = liked;}

    public String timeSince(LocalDateTime currentTime) {
        Duration duration = Duration.between(dateTime, currentTime);
        long minutes = duration.toMinutes();

        if (minutes < 1) {
            return "just now";
        } else if (minutes < 2) {
            return "a minute ago";
        } else if (minutes < 60) {
            return minutes + " minutes ago";
        } else if (minutes < 120) {
            return "an hour ago";
        } else if (minutes < 1440) {
            return (minutes / 60) + " hours ago";
        } if (minutes < 2880) {
            return "yesterday";
        } else {
            return (minutes / 1440) + " days ago";
        }
    }
}
