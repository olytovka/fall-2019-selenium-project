package com.cybertek.tests.day10_webelements;


import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {

    String title;

    @Test(priority = 0)
    public void login(){
        System.out.println("open the browser");
        System.out.println("capturing the title");
        title = "cbt";
    }

    @Test(priority = 1, dependsOnMethods = "login")
    public void assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title,"cbt");
    }

    @Test (priority = 5)
    public void verifyOtherThings(){
        System.out.println("verify smth else");
    }

}
