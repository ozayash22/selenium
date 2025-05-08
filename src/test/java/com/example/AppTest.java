package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager; // <-- Add this import

public class AppTest {

    @Test
    public void testGoogleTitle() {
        // Automatically downloads the correct ChromeDriver version
        WebDriverManager.chromedriver().setup();  // <-- Add this line

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
            assertTrue(title.contains("Google"), "Title should contain 'Google'");
        } finally {
            driver.quit();
        }
    }
}
