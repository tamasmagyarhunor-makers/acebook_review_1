package com.makersacademy.acebook.feature;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LikesTest {

    WebDriver driver;
    Faker faker;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        faker = new Faker();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void successfulLikesAndUnlikes() {
        String email = faker.name().username() + "@email.com";

        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("P@55qw0rd");
        driver.findElement(By.name("action")).click();
        driver.findElement(By.name("action")).click();
        String greetingText = driver.findElement(By.id("greeting")).getText();
        Assert.assertEquals("Signed in as " + email, greetingText);

        driver.get("http://localhost:8080/");
        driver.findElement(By.className("like-group")).click();
        Assert.assertEquals("Liked", driver.findElement(By.className("like-group")).getText());

        driver.navigate().refresh();
        Assert.assertEquals("Liked", driver.findElement(By.className("like-group")).getText());

        driver.findElement(By.className("like-group")).click();
        Assert.assertEquals("Like", driver.findElement(By.className("like-group")).getText());

        driver.navigate().refresh();
        Assert.assertEquals("Like", driver.findElement(By.className("like-group")).getText());
    }
}
