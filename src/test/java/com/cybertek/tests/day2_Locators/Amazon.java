package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Amazon {
    static WebDriver driver;

    static void takeScreenShot(String fileName) throws IOException, InterruptedException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/olha/Desktop/screen" + fileName + ".png"));
        Thread.sleep(3000);
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.navigate().to("https://www.ebay.com/");
        Thread.sleep(3000);

       WebElement send =  driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
       send.sendKeys("wooden spoon");
       Thread.sleep(2000);

       WebElement click = driver.findElement(By.id("gh-btn"));
       click.click();

       String expectedTitle = "wooden spoon | eBay";
       String actualTitle = driver.getTitle();

       if(expectedTitle.equals(actualTitle)){
           System.out.println("PASS for Title");
       }else{
           System.out.println("FAIL for Title");
       }


       String expectedUrl = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xwooden+spoon.TRS0&_nkw=wooden+spoon&_sacat=0";
       String actualUrl = driver.getCurrentUrl();

       if(expectedUrl.equals(actualUrl)){
           System.out.println("PASS for URL");
       }else{
           System.out.println("FAIL for URL");
       }

       Thread.sleep(2000);

       takeScreenShot("MyFirstAutomatedScreenShot2");


       driver.close();









    }
}
