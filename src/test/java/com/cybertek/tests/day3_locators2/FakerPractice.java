package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FakerPractice {
    public static void main(String[] args) throws InterruptedException {


        Faker fakeData = new Faker();


        String name = fakeData.name().firstName();
        System.out.println(name);

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

      driver.get("http://practice.cybertekschool.com/login");

      WebElement email = driver.findElement(By.name("username"));
      email.sendKeys(name);
      Thread.sleep(2000);

      WebElement password = driver.findElement(By.name("password"));
      password.sendKeys(name+Keys.ENTER);
      Thread.sleep(2000);

      String error ="Your username is invalid!";

    String  dd =  driver.findElement(By.id("flash")).getText();

        if(dd.contains(error)){
            System.out.println("Error message is correct " + dd );
        }else{
            System.out.println("Error message is different " + dd);
        }

        driver.close();


    }
}
