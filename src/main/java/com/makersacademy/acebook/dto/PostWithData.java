package com.makersacademy.acebook.dto;

import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.UserRepository;
import com.makersacademy.acebook.service.PostDataService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

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

    public Long getId() { return id; }
    public String getContent() { return content; }
    public String getUserId() { return userId; }
    public Boolean getFriendsOnly() { return friendsOnly; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getNickname() { return nickname; }
    public boolean getLiked() { return liked; }

    public void setId(Long id) { this.id = id; }
    public void setContent(String content) { this.content = content; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setFriendsOnly(boolean friendsOnly) { this.friendsOnly = friendsOnly; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setLiked(boolean liked) { this.liked = liked; }

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

    public String getLikedString(String currentUserId) {
        StringBuilder likedString = new StringBuilder();
        List<User> users = getUsersWhoLiked();

        int count = 0;
        int total = users.size();

        // If currentUser likes this post, 'You' goes at the front of the string.
        if (liked) {
            count++;
            likedString
                    .append("You")
                    .append(getJoinString(total - count));
        }

        for (User user : users) {
            if (user.getAuth0Id().equals(currentUserId)) continue; // skip the currentUser
            count++;
            likedString
                    .append(user.getNickname())
                    .append(getJoinString(total - count));
        }

        likedString.append("liked this");
        return total > 0 ? likedString.toString() : "";
    }

    public List<User> getUsersWhoLiked() {
        PostDataService postDataService = new PostDataService();
        return postDataService.getUsersWhoLiked(id);
    }

    private String getJoinString(int itemsRemaining) {
        return itemsRemaining > 1 ? ", " : itemsRemaining == 1 ? " and " : " ";
    }
}
