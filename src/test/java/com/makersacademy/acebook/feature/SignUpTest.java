package com.makersacademy.acebook.feature;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getenv;

public class SignUpTest {

    Faker faker;

    @BeforeEach
    public void setup() {
        faker = new Faker();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void successfulSignUpAlsoLogsInUser() throws InterruptedException {
        String email = faker.name().username() + "@email.com";

    }
}
