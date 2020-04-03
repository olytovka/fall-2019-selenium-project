package com.cybertek.tests.office_hours1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleSearchTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");

        List<String> searchStrs = Arrays.asList("Java","cucumber bdd","Selenium web browser automation" );

        for(String searchStr : searchStrs){
            WebElement searchInput =  driver.findElement(By.name("q"));
            searchInput.sendKeys(searchStr+ Keys.ENTER);
        }

    }
}
