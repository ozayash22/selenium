package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {

    @Test
    public void testGoogleTitle() {
        // Set Chrome options for headless execution (required in CI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use new headless mode (faster + more stable)
        options.addArguments("--no-sandbox"); // Required in CI (avoids permission issues)
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues in containers

        // Create Chrome driver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
            assertTrue(title.contains("Google"), "Title should contain 'Google'");
        } finally {
            driver.quit(); // Always quit the driver
        }
    }
}

