package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {

    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to cybertek practice web site
        2. Verify title


        Actual result? --->

        http://practice.cybertekschool.com/
         */

        //connect browser and your driver
        //set up browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");

        driver.manage().window().maximize();

        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        String actualTitle = driver.getTitle();
        Thread.sleep(3000);
        driver.quit();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The Actual title is " + actualTitle);
        }


    }
}
