package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("storemanager52");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        WebElement click = driver.findElement(By.id("_submit"));
        click.click();


    }
}
