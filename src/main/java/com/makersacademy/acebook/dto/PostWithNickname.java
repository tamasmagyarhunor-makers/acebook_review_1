package com.makersacademy.acebook.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

public class PostWithNickname {
    private Long id;
    private String content;
    private String userId;
    private Boolean friendsOnly;
    private LocalDateTime dateTime;
    private String nickname;

    public PostWithNickname(Long id, String content, String userId, Boolean friendsOnly, LocalDateTime dateTime, String nickname) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.friendsOnly = friendsOnly;
        this.dateTime = dateTime;
        this.nickname = nickname;
    }

    public PostWithNickname() {};

    public Long getId() {return this.id;}
    public String getContent() {return this.content;}
    public String getUserId() {return this.userId;}
    public Boolean getFriendsOnly() {return this.friendsOnly;}
    public LocalDateTime getDateTime() {return this.dateTime;}
    public String getNickname() {return this.nickname;}

    public void setId(Long id) {this.id = id;}
    public void setContent(String content) {this.content = content;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setFriendsOnly(boolean friendsOnly) {this.friendsOnly = friendsOnly;}
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}
    public void setNickname(String nickname) {this.nickname = nickname;}

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
