package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRIENDS")
@IdClass(Friends.FriendsId.class)
public class Friends {
    @Id
    private String userA;
    @Id
    private String userB;

    public Friends(String userA, String userB) {
        this.userA = userA;
        this.userB = userB;
    }

    public Friends() {}

    public String getUserA() {return this.userA;}
    public String getUserB() {return this.userB;}
    public void setUserA(String userA) {this.userA = userA;}
    public void setUserB(String userB) {this.userB = userB;}

    public static final class FriendsId implements Serializable {
        private String userA;
        private String userB;

        public FriendsId(String userA, String userB) {
            this.userA = userA;
            this.userB = userB;
        }

        public FriendsId() {}

        public String getUserA() {return this.userA;}
        public String getUserB() {return this.userB;}
        public void setUserA(String userA) {this.userA = userA;}
        public void setUserB(String userB) {this.userB = userB;}
    }
}
