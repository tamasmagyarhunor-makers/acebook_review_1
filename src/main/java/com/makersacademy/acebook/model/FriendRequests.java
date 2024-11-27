package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "friend_requests")
public class FriendRequests {
    @Id
    private String requestingUser;
    @Id
    private String requestedUser;

    public FriendRequests(String requestingUser, String requestedUser) {
        this.requestingUser = requestingUser;
        this.requestedUser = requestedUser;
    }
}