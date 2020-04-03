package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodOfXpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        WebElement text = driver.findElement(By.xpath("//h3[text()='Context Menu']"));

        String expectedText = "Context Menu";

        String actualText =  text.getText();

        if(expectedText.equals(actualText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


    }
}
