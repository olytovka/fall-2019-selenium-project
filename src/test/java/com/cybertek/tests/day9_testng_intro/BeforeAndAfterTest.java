package com.cybertek.tests.day9_testng_intro;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("this is from before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AFTER METHOD");
    }


   @Test
   public void test1(){
       System.out.println("this is test one");
//       Assert.assertEquals(true, false);
    }

    @Test
    public void test2(){
        System.out.println("this is test two");
    }



}
