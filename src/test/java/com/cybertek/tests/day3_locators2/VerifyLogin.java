package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword"+ Keys.ENTER);
        Thread.sleep(2000);

        WebElement welcomeMessage = driver.findElement(By.tagName("h4"));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = welcomeMessage.getText();
        if (expectedMessage.equalsIgnoreCase(actualMessage)){
            System.out.println("PASSS");
        }else {
            System.out.println("Fail");
        }
            Thread.sleep(2000);

        driver.close();







        }


}
