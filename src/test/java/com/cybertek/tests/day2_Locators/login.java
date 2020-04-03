package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("storemanager52");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        WebElement click = driver.findElement(By.id("_submit"));
        click.click();

        String url = "https://app.vytrack.com/";
        String title = "Dashboard";
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        if(actualUrl.equals(url)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Wrong Url!!!");
        }

        if(actualTitle.equals(title)){
            System.out.println("Title is matching. Test Pass");
        }else{
            System.out.println("Title is wrong");
        }


        driver.quit();


    }
}
