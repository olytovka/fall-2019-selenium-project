package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertekschool.okta.com/");

        driver.manage().window().maximize();

        Thread.sleep(3000);


        WebElement emailbox = driver.findElement(By.id("okta-signin-username"));
        emailbox.sendKeys("olhalytovka@gmail.com");

        //
        driver.findElement(By.id("okta-signin-password")).sendKeys("password");


        WebElement push = driver.findElement(By.id("okta-signin-submit"));
        push.click();

    }
}
