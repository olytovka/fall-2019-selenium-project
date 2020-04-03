package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CssPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Olha privet");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("asdfvb");


    }
}
