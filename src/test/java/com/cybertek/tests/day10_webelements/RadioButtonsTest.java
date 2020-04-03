package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = new WebDriverFactory().getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    /* default behaviour
    go to http://practice.cybertekschool.com/radio_buttons
    verify that blue is selected
    red is not selected
     */

    @Test
    public void test1(){
        WebElement blue = driver.findElement(By.id("blue"));
        //isSelected -> returns true if element is selected
        System.out.println(blue.isSelected());

        //verifying if the radio button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        System.out.println(red.isSelected());

        //verifies if the statements is false, if false it is passes, if false fails
        Assert.assertFalse(red.isSelected());

    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }


    /*
    go to http://practice.cybertekschool.com/radio_buttons
    click on red
    verify that blue is not selected

     */

    @Test
    public void test2(){
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();

        //verify is blue is not selected
        Assert.assertFalse(blue.isSelected());
        Assert.assertTrue(red.isSelected());
    }

}
