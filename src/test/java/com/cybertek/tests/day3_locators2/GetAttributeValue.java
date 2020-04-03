package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));

        String valueOfType  = username.getAttribute("type");
        System.out.println("The value of type is " + valueOfType);


        WebElement password = driver.findElement(By.id("wooden_spoon"));
        String valueOf = password.getAttribute("type");
        System.out.println("Password attribute is: " + valueOf);

        Thread.sleep(2000);

        //getText() vs getAttribute()
        //get text gives everything on the page
        //getAttribute gives give evrything  inside double quotes



        driver.close();

    }
}
