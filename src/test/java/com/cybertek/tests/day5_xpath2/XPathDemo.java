package com.cybertek.tests.day5_xpath2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathDemo {
    public static void main (String [] args){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons ");

        driver.manage().window().maximize();


        WebElement buttonOne =  driver.findElement(By.xpath("//button[@onclick='button1()']"));

        String txt = buttonOne.getText();
        System.out.println(txt);


        WebElement buttonTwo =  driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText() );

//        WebElement buttonThree =  driver.findElement(By.xpath(""));
//        WebElement buttonFour =  driver.findElement(By.xpath(""));
//        WebElement buttonFive =  driver.findElement(By.xpath(""));
//        WebElement buttonSix =  driver.findElement(By.xpath(""));

        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());

        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());

        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button 5']"));
        System.out.println(buttonFive.getText());

        WebElement buttonSix= driver.findElement(By.xpath("//button[@id='disappearing_button']"));
        // element.getAttribute("value")  --. method to get text form element, used with input boxes alot
        // get text of the element

        System.out.println(buttonSix.getAttribute("innerHTML"));
        // if none of the works use outerHTML
        System.out.println(buttonSix.getAttribute("outerHTML"));


        System.out.println();
    }
}
