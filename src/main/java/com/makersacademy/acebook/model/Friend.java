package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.*;
import com.makersacademy.acebook.dto.FriendId;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "friends")
public class Friend {

    @EmbeddedId
    private FriendId id;  // Composite primary key

    // Additional constructors if needed
    public Friend(String userA, String userB) {
        this.id = new FriendId(userA, userB);
    }
}
