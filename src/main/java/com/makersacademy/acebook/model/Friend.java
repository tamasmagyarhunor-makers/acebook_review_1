package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RestController
@Table(name = "friends")
public class Friend {
    @EmbeddedId
    private String userA;
    @EmbeddedId
    private String userB;

    public void FriendRequests(String userA, String userB) {
        this.userA = userA;
        this.userB = userB;
    }

}