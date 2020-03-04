package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Navigation {
    /*
       Navigation:
       driver.navigate().to("URL")
       driver.navigate().back()
       driver.navigate().forward()
       driver.navigate().refresh()
*/
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // I want to see the full window
        driver.manage().window().fullscreen();

        String practiceURL = "http://practice.cybertekschool.com/";
        // go to practice
        String ggURL = "https://www.google.com/";

        driver.get(practiceURL);
        Thread.sleep(3000);
        driver.navigate().to(ggURL);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();

        driver.navigate().refresh();
        Thread.sleep(3000);

        //close driver automatically

        driver.close(); // will close only website

        driver.quit(); // will close whole window


    }


}
