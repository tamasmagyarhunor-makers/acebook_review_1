package com.makersacademy.acebook.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectMessageTest {

    private DirectMessage directMessage = new DirectMessage("hi how are you");
    @Test
    public void sendDirectMessage() {assertThat(directMessage.getMessage(), containsString("hi how are you")); }

}
