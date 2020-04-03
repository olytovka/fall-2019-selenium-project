package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class XpathPractice {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("olhalytovka@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[2]/div/input")).sendKeys("123abc45"+ Keys.ENTER);

     


        driver.close();



    }
}
