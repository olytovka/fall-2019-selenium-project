package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutedTests {
    WebDriver driver;
    JavascriptExecutor jse;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("firefox");
        jse = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }


    @Test
    public void scroll(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        jse.executeScript("arguments[0].scrollIntoView(true);", link);

    }

    @Test
    public void sendKeysWithJs(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement input = driver.findElement(By.cssSelector("input[disabled]"));
        String text = "hi world";

        jse.executeScript("arguments[0].setAttribute('value', '" +text + "')",input);



    }


}
