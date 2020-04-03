package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.id("form_submit"));
            String text = button.getAttribute("type"); //submit
        System.out.println(text);

        System.out.println(button.getAttribute("class")); //radius

        System.out.println(button.getAttribute("id")); //for_submit

        Thread.sleep(2000);


        driver.close();

    }
}
