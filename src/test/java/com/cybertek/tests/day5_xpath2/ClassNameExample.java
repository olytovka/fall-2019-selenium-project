package com.cybertek.tests.day5_xpath2;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class         ClassNameExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        WebElement link = driver.findElement(By.className("nav-link"));
        System.out.println(link.getText());

        //class name does not work

//        WebElement loginBtn = driver.findElement(By.className("btn btn-primary"));
//        loginBtn.click();
        // No Such Element Exception















    }
}
