package com.cybertek.tests.office_hours2;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class SelectClassPracticeTests {

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
    go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    verify that table has dropdown with values Family, Friends, Co-workers, Businesses, Contacts

    select option Co-workers
    verify that Co-workers is now selected
    select option Contacts
    verify that Contacts is selected
     */
    @Test
    public void test() throws InterruptedException {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        // getOptions --> gives all available options as a list of web elements
       List<WebElement> allOptionsEl =  categories.getOptions();

        System.out.println("number of options: " + allOptionsEl.size());


        List <String> expectedOptions =  Arrays.asList("Family", "Friends", "Coworkers", "Businesses", "Contacts");

        // give a list of web elements, extract the text of the elements into new list of strings
        List <String> allOptionsStr = BrowserUtils.getElementsText(allOptionsEl);

        Assert.assertEquals(allOptionsStr, expectedOptions);
    }

      /*
    go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    select option Co-workers
    verify that Co-workers is now selected
    select option Contacts
    verify that Contacts is selected
     */

      @Test
    public void test2() throws InterruptedException {
          driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
          Thread.sleep(2000);
          Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

          //select option Coworkers
          categories.selectByVisibleText("Coworkers");
         // verify that Co-workers is now selected
          String actual = categories.getFirstSelectedOption().getText();
          Assert.assertEquals(actual,"Coworkers");
          categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
//          select option Contacts
          categories.selectByVisibleText("Contacts");
          categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

//          verify that Contacts is selected
         actual = categories.getFirstSelectedOption().getText();
          Assert.assertEquals(actual,"Contacts");
      }

      /*
      go to http://practice.cybertekschool.com/dropdown
      verify that days table has days in ascending order
       */

      @Test
    public void test3(){
          driver.get("http://practice.cybertekschool.com/dropdown");
          Select days = new Select(driver.findElement(By.id("day")));
          List <WebElement> options =  days.getOptions();
          System.out.println("Number of options: " + options.size());

          // i have a list of web elements, i need to verify if the values(numbers)  are sorted is ascending order
          // list of web element to list of string
          List <String> stringList = BrowserUtils.getElementsText(options);

          //lust of string to list of ints
          List<Integer> ints = new ArrayList<>();

          for (String string : stringList) {
           ints.add(Integer.parseInt(string));
          }

          System.out.println(ints);

          //verify list of ints is sorted
          List <Integer> intsCopy = new ArrayList<>(ints);

          //sorting the copy
          Collections.sort(intsCopy);
          //compare
          Assert.assertEquals(ints, intsCopy);
      }




}
