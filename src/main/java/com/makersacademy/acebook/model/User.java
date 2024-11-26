package com.makersacademy.acebook.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.lang.Boolean.TRUE;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private boolean enabled;
    private String nickname;
    private LocalDateTime lastLogin;

    public User(String userId, String nickname, LocalDateTime lastLogin) {
        this.userId = userId;
        this.enabled = TRUE;
        this.nickname = nickname;
        this.lastLogin = lastLogin;
    }

    public User(String userId, boolean enabled, String nickname, LocalDateTime lastLogin) {
        this.userId = userId;
        this.enabled = enabled;
        this.nickname = nickname;
        this.lastLogin = lastLogin;
    }

    // everything beneath this line: I know. But lombok isn't handling these setters correctly.

    public User() {
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
