package com.makersacademy.acebook.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


public class DirectMessageTest {
    @Test
    public void sendDirectMessage() {
        DirectMessage directMessage = new DirectMessage("hi how are you", "1", "2", LocalDateTime.now());
        Assert.assertEquals("hi how are you", directMessage.getContent());
    }
}
