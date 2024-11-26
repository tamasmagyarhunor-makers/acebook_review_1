package com.makersacademy.acebook.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
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
}
