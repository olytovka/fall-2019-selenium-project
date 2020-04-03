package com.cybertek.tests.day4_xpath;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSubmit {
    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.manage().window().maximize();

        Thread.sleep(3000);

      driver.findElement(By.name("email")).sendKeys("johndoe@gmail.com");

      Thread.sleep(2000);

      WebElement button = driver.findElement(By.id("form_submit"));
      button.click();

      String expectedUrl = "http://practice.cybertekschool.com/email_sent";

      String actualUrl = driver.getCurrentUrl();

      if(expectedUrl.equals(actualUrl)){
          System.out.println("PASS");
      }else{
          System.out.println("FAIL");
      }

      Thread.sleep(2000);

      driver.close();
    }
}
