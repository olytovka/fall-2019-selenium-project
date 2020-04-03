package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.manage().window().maximize();

        Thread.sleep(2000);

      WebElement text =  driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));

        System.out.println(text.getAttribute("href"));

        Thread.sleep(2000);

        driver.close();

    }
}
