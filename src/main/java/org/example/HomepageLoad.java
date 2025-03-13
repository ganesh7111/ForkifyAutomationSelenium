package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Instant;

public class HomepageLoad {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Start Time
        Instant startTime = Instant.now();

        try {
            // Navigate to Website
            driver.get("https://forkify.alexandrasimion.com/");

            // End Time
            Instant endTime = Instant.now();

            // Calculate Load Time
            Duration duration = Duration.between(startTime, endTime);

            // Verify Page Title
            String expectedTitle = "forkify // Search over 1,000,000 recipes";
            String actualTitle = driver.getTitle();

            if (actualTitle.contains(expectedTitle)) {
                System.out.println("Total Time Taken To Load Page: " + duration.toMillis() + " ms");
                System.out.println("HomePage Loaded Successfully Without any errors");
            } else {
                System.out.println("HomePage Not Loaded Successfully Without any errors");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println("HomePage Not Loaded Successfully Without any errors");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
