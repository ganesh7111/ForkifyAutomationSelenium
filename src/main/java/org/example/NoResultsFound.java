package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NoResultsFound {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://forkify.alexandrasimion.com/");
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Locate and enter ingredient in the search field
            WebElement searchField = driver.findElement(By.className("search__field"));
            searchField.sendKeys("Bike");

            // Click the search button
            WebElement searchButton = driver.findElement(By.cssSelector(".btn.search__btn"));
            searchButton.click();

            // Explicit wait to verify the "NO Results found"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           WebElement errormessage =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'No recipes found for your query. Please try again!')]")));
            if(errormessage.isDisplayed()){
                System.out.println("A message displayed indicating that no recipes were found");
            }else{
                System.out.println("No results message was not displayed.");

            }
        } catch (Exception e) {
            System.out.println("An error Occured: "+ e.getMessage());
            System.out.println("No results message not found or an error occurred.");
        } finally{
            driver.quit();
        }
    }
}
