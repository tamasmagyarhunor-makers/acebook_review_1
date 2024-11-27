package com.makersacademy.acebook.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FriendId implements Serializable {
    @Column(insertable=false, updatable=false)
    private String user_a;
    @Column(insertable=false, updatable=false)
    private String user_b;

    public FriendId(String user_a, String user_b) {
        this.user_a = user_a;
        this.user_b = user_b;
    }

    public FriendId() {}

    public String getUserA() {
        return user_a;
    }
    public void setUserA(String user_a) {
        this.user_a = user_a;
    }
    public String getUserB() {
        return user_b;
    }
    public void setUserB(String user_b) {
        this.user_b = user_b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendId friendId = (FriendId) o;
        return Objects.equals(user_a, friendId.user_a) &&
                Objects.equals(user_b, friendId.user_b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_a, user_b);
    }
}