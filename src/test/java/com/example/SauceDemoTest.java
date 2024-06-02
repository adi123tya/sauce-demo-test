package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class SauceDemoTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckoutFlow() {
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Select 3 random items
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            WebElement item = inventoryItems.get(rand.nextInt(inventoryItems.size()));
            item.findElement(By.className("btn_inventory")).click();
        }

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        // Assert checkout complete
        String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(confirmationMessage, "THANK YOU FOR YOUR ORDER");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
