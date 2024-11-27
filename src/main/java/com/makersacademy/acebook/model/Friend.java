package com.makersacademy.acebook.model;

import com.makersacademy.acebook.dto.FriendId;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRIENDS")
public class Friend {
    @EmbeddedId
    private FriendId id;
    private String user_a;
    private String user_b;

    public Friend(String user_a, String user_b) {
        this.user_a = user_a;
        this.user_b = user_b;
    }

    public Friend() {}

    public FriendId getId() {return id;}
    public void setId(FriendId id) {this.id = id;}
    public String getUser_a() {return this.user_a;}
    public String getUser_b() {return this.user_b;}
    public void setUser_a(String user_a) {this.user_a = user_a;}
    public void setUser_b(String user_b) {this.user_b = user_b;}
}
