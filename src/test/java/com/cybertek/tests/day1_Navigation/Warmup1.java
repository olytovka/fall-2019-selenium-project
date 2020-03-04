package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warmup1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String expectedURL = "https://cybertek-reservation-qa.herokuapp.com/sign-in";

        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        String title = driver.getTitle();

        if(title.equals("cybertek-reservation")){
            System.out.println("Title is cybertek-reservation");
        }else{
            System.out.println("FAIL, Title is not cybertek-reservation");
        }

        driver.close();
    }
}
