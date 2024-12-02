package com.makersacademy.acebook.feature;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LikeTest {

    Page page;
    Faker faker;
    Playwright playwright;
    BrowserContext context;

    @BeforeEach
    public void setup() {
        faker = new Faker();
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        playwright.close();
    }

    @Test
    public void testLikeFeature() {
        page.setDefaultTimeout(6000);
        page.getByText("Sign up").click();
        String email = faker.name().username() + "@email.com";
        page.locator("#email").fill(email);
        page.locator("#password").fill("P@s5W0rd");
        page.getByText("Continue").nth(1).click();
        page.getByText("Accept").click();

        page.locator("#postContent").fill("This is a test post.");
        page.getByText("Post").click();
        page.waitForSelector(".post-container");

        page.locator(".like-button").click();
        String likeCountText = page.locator(".like-count").innerText();
        assert likeCountText.equals("1");

        page.reload();
        String refreshedLikeCountText = page.locator(".like-count").innerText();
        assert refreshedLikeCountText.equals("1");

        page.locator(".like-button").click();
        String unlikeCountText = page.locator(".like-count").innerText();
        assert unlikeCountText.equals("0");
    }
}
