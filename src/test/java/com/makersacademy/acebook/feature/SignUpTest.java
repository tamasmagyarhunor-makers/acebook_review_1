package com.makersacademy.acebook.feature;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpTest {

    WebDriver driver;
    Faker faker;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/opt/hostedtoolcache/setup-chrome/chromedriver");
        driver = new ChromeDriver();
        faker = new Faker();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void successfulSignUpAlsoLogsInUser() {
        String email = faker.name().username() + "@email.com";

        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("P@55qw0rd");
        driver.findElement(By.name("action")).click();
        driver.findElement(By.name("action")).click();
        String greetingText = driver.findElement(By.id("greeting")).getText();
        Assert.assertEquals("Signed in as " + email, greetingText);
    }
}
