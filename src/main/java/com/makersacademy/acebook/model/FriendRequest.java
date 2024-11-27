package com.makers.acebook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "friend_requests")
public class FriendRequest {
    private String requesting_user;
    private String requested_user;

    public FriendRequest(String requesting_user, String requested_user) {
        this.requesting_user = requesting_user;
        this.requesting_user = requested_user;
    }
}
