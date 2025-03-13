package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFunctionality {
    public static void main(String[] args) throws InterruptedException  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://forkify.alexandrasimion.com/");
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Locate and enter ingredient in the search field
            WebElement searchField = driver.findElement(By.className("search__field"));
            searchField.sendKeys("Rice");

            // Click the search button
            WebElement searchButton = driver.findElement(By.cssSelector(".btn.search__btn"));
            searchButton.click();

            // Explicit wait to verify results
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("results")));
            System.out.println("Search results displayed recipes containing the entered ingredient.");
        } catch (Exception e) {
            System.out.println("An error Occured: "+ e.getMessage());
            System.out.println("Search results not displayed.");
        } finally{
            driver.quit();
        }
    }
}
