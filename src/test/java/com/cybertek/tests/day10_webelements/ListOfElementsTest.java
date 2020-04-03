package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = new WebDriverFactory().getDriver("chrome");
//        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }


    /*
    go to page radio buttons
    verify that non of the sports radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // driver.findElements --> returns a LIST of element
        // returns all the elements that have matching locator
        // if the locator does not match anything, it does not throw exception, it just returns empty list

        Thread.sleep(1000);
        List <WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());

       for(WebElement radioButton : sports){
            Assert.assertFalse(radioButton.isSelected());
       }
    }
    /*
    go to practice website
    get all the links present in the page
    print their text
     */

    @Test
    public void getAllLinkTest(){
      driver.get("http://practice.cybertekschool.com/");

      //get all the links in a page
        List <WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        //get the text of each link and print
        for(WebElement link : links){
            System.out.println(link.getText());
        }
    }

    /*
    got to amazon.com
    search for "paper towel"
    print the number of results
    print the first result
    print second result
    print the last result
     */

    @Test
    public void amazonTest() throws InterruptedException{
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels" + Keys.ENTER);

        Thread.sleep(2000);

        List <WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        System.out.println("number of results: " + allResults.size());

        System.out.println("First result: " + allResults.get(0).getText());
        System.out.println();
        System.out.println("Second result: " + allResults.get(1).getText());
        System.out.println();
        System.out.println("Last result: " + allResults.get(allResults.size()-1).getText());
    }

    /*
    go to radio buttons website
    verify that all sports checkboxes are unchecked by default
    randomly click any sport
    verify that that sport is clicked
    verify that all others are not clicked
    repeat the last step for 5 times
     */

    @Test
    public void sportList() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        Thread.sleep(1000);
        List <WebElement> list = driver.findElements(By.name("sport"));

        //verify nothing is selected
        //checking all the sport checkboxes are unchecked
        for(int i =0; i<list.size(); i++ ){
            Assert.assertFalse(list.get(i).isSelected());
        }

        Thread.sleep(2000);
        //randomly clicking and verifying
        Random ran = new Random();
        int num;
        for(int q =0; q<5; q++){
            Thread.sleep(2000);
            num =  ran.nextInt(4);
            list.get(num).click();
            System.out.println("Selecting button number: " + num +1);

            for(int i =0;i<list.size();i++){
                if(i==num){
                    Assert.assertTrue(list.get(num).isSelected());
                }else{
                    Assert.assertFalse(list.get(i).isSelected());
                }
            }

        }
    }


}
