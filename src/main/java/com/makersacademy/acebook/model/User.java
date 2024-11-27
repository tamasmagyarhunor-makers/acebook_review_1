package com.makersacademy.acebook.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.lang.Boolean.TRUE;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "auth0_id")
    private String auth0Id;
    private boolean enabled;
    private String nickname;
    private LocalDateTime lastLogin;

    public User(String auth0Id, String nickname, LocalDateTime lastLogin) {
        this.auth0Id = auth0Id;
        this.enabled = TRUE;
        this.nickname = nickname;
        this.lastLogin = lastLogin;
    }

    public User(String auth0Id, boolean enabled, String nickname, LocalDateTime lastLogin) {
        this.auth0Id = auth0Id;
        this.enabled = enabled;
        this.nickname = nickname;
        this.lastLogin = lastLogin;
    }

    public User() {
    }

    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}
    public String getAuth0Id() {return this.auth0Id;}
    public void setAuth0Id(String auth0Id) {this.auth0Id = auth0Id;}
    public boolean getEnabled() {return this.enabled;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    public String getNickname() {return this.nickname;}
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public LocalDateTime getLastLogin() {return this.lastLogin;}
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
