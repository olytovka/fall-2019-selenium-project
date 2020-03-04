package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String ggTitle = "Google";

        Thread.sleep(2000);

        driver.get("https://www.etsy.com/");
        String etsyExpectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Thread.sleep(2000);

        driver.navigate().back(); //google

        String actualTitleGoogleTitle = driver.getTitle();



        if(ggTitle.equals(actualTitleGoogleTitle)){
            System.out.println("Same");
        }else{
            System.out.println("Different");
            System.out.println("Expected " + ggTitle);
            System.out.println("Actual " + actualTitleGoogleTitle);
        }

        Thread.sleep(2000);

        driver.navigate().forward();
        String etsyActualTitle = driver.getTitle();



        if(etsyExpectedTitle.equals(etsyActualTitle)){
            System.out.println("Same");
        }else{
            System.out.println("Different");
            System.out.println("Expected " + etsyExpectedTitle);
            System.out.println("Actual " + etsyActualTitle);
        }

        driver.close();



    }
}
