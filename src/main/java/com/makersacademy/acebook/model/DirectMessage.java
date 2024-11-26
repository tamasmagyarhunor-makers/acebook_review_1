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
    private String sender_id;
    private String receiver_id;
    private LocalDateTime date_time;

    public DirectMessage(String content, String senderId, String receiverId, LocalDateTime dateTime) {
        this.content = content;
        this.sender_id = senderId;
        this.receiver_id = receiverId;
        this.date_time = dateTime;
    }
}
