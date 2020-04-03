package com.cybertek.tests.office_hours2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

        /*
      go to google.com
      move your mouse on top i'm feeling lucky
      verify that button now has a different text
      do this many times
      When you get "I am feeling Stellar 3 times", print "Deal with it" in console and exit the program
       */

    @Test
    public void google(){
        driver.get("https://www.google.com/");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("gbqfbb"));
        actions.moveToElement(button).pause(2000).build().perform();

        String notUnExpected = "I'm Feeling Lucky";

        String actual =  button.getAttribute("value");
        System.out.println("Actual: "+ actual);

        Assert.assertNotEquals(actual,notUnExpected);
        // didn't finish!!!
    }
}
