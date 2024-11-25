package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.Data;




@Data
@Entity
@Table(name = "MESSAGES")

public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String message;
    private String sender_id;
    private String recipient_id;
    private LocalDateTime timestamp;

    public DirectMessage() {}

 public DirectMessage(String content, String senderId, String recipientId, LocalDateTime dateTime) {
       this.message = content;
        this.sender_id = senderId;
        this.recipient_id = recipientId;
        this.timestamp = dateTime != null ? dateTime : LocalDateTime.now();
    }
    public DirectMessage(String message) {this.message = message;}

    public String getMessage() {return this.message; }
    public void  setMessage(String message) { this.message = message; }
}
