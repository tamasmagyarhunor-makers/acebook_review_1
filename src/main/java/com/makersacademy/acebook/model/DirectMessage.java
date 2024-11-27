package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "DIRECT_MESSAGES")
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String senderId;
    private String receiverId;
    private LocalDateTime dateTime;

    public DirectMessage(String content, String senderId, String receiverId, LocalDateTime dateTime) {
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.dateTime = dateTime;
    }
}
