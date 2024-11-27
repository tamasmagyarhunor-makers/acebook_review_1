package com.makersacademy.acebook.dto;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FriendId implements Serializable {

    private String user_a;
    private String user_b;

    public FriendId() {}

    public FriendId(String user_a, String user_b) {
        this.user_a = user_a;
        this.user_b = user_b;
    }

    // Getters and setters
    public String getUser_a() {
        return user_a;
    }

    public void setUser_a(String user_a) {
        this.user_a = user_a;
    }

    public String getUser_b() {
        return user_b;
    }

    public void setUser_b(String user_b) {
        this.user_b = user_b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendId friendID = (FriendId) o;
        return user_a.equals(friendID.user_a) && user_b.equals(friendID.user_b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_a, user_b);
    }
}