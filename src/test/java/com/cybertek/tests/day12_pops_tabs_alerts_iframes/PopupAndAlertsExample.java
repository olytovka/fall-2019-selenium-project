package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlertsExample {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void htmlPopup() throws InterruptedException{
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        button.click();

        Thread.sleep(2000);
        WebElement noo = driver.findElement(By.xpath("//span[.='No']"));
        noo.click();
        Thread.sleep(2000);
    }

    @Test
    public void jsAlertsAccept(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();

        Alert alert =  driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void jsAlertsCancel(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button2= driver.findElement(By.xpath("//button[2]"));
        button2.click();

        Alert alert =  driver.switchTo().alert();
        alert.dismiss();
    }

    @Test
    public void jsAlertsSendKeys(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button3= driver.findElement(By.xpath("//button[3]"));
        button3.click();

        Alert alert =  driver.switchTo().alert();
        alert.sendKeys("Admiral Kunkka");
        alert.accept();
    }





}
