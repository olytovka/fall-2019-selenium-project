package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //how to close pop out window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver =new ChromeDriver(options);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("email")).sendKeys("o4arovawe4ka_94@mail.ru");

        Thread.sleep(3000);

        driver.findElement(By.id("pass")).sendKeys("123456789L"+ Keys.ENTER);

        Thread.sleep(3000);

        driver.findElement(By.className("_1frb")).sendKeys("arman birmagambetov" + Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.linkText("Birmagambetov Arman")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/a")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div/div[4]/div/div[1]/div/div/div/div/div/div/div/div[2]/div[4]/div/div/div/span/div/div/div[2]/div/div/div/div")).sendKeys("Test"+Keys.ENTER);

         Thread.sleep(2000);

         driver.close();






    }
}
