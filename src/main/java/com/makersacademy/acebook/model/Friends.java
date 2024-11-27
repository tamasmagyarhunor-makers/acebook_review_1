package com.makers.acebook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "friends")
public class Friend {
    private String user_a;
    private String user_b;

    public Friends(String user_a, String user_b) {
        this.user_a = user_a;
        this.user_b = user_b;
    }
}
