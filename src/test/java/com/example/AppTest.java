package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
    @Test
    public void testGoogleTitle() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // run headless in CI
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertTrue(title.contains("Google"));
        driver.quit();
    }
}

