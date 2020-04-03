package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.cssSelector("html>body>nav>ul a"));
        // by class : .nav-link
        // by id : #disapearing_button
        // by tagname: h4
        // by child: html>body>nav>ul>li>a
        // by descendant: html>body>nav>ul a
        // by attribute and value: button[onlclick='button1()']
        // by  attribute and any tag [onclick='button1()']

        System.out.println(button.getText());

        driver.quit();


    }
}
