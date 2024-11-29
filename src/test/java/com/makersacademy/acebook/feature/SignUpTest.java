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

    WebDriver driver;
    Faker faker;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        if (Objects.equals(getenv("GITHUB_ACTIONS"), "true")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            options.addArguments("headless");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        }
        options.setBrowserVersion("118v");
        driver = new ChromeDriver(options);
        faker = new Faker();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void successfulSignUpAlsoLogsInUser() throws InterruptedException {
        String email = faker.name().username() + "@email.com";

        driver.get("https://127.0.0.1:8080/");
        TimeUnit.SECONDS.sleep(30);


        driver.findElement(By.linkText("Sign up"));//.click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("P@55qw0rd");
        driver.findElement(By.name("action")).click();
        driver.findElement(By.name("action")).click();
        String greetingText = driver.findElement(By.id("greeting")).getText();

        Assert.assertEquals("Signed in as " + email, greetingText);
    }
}
