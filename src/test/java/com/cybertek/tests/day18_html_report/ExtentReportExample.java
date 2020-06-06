package com.cybertek.tests.day18_html_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportExample {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest test;
    @BeforeMethod
    public void setUp(){

        //initialize the report
        report = new ExtentReports();

        // i need to point to the location where report will be create
        // System.getProperty("user.dir") => gets my current folder
        // + "test-output/report.html" => create folder test-output and in it create file report.html

        String path = System.getProperty("user.dir")+"/test-output/report.html";

        //initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);

        //se name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        //attach the html reporter to the report object
        report.attachReporter(htmlReporter);

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", "Chrome");
    }

    @Test
    public void test(){
        // we have to create a test for every test case
        // make sure to put this line on top your test but not in the before method, otherwise it will give NullPointerException
        test =  report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        // driver =  new ChromeDriver();
        test.info("going to website");
        // driver.get("google.com");
        test.info("verifying title");
        //assertEquals(google, google);
        test.pass("VYT-123 Title verification test");
    }



    @AfterMethod
    public void tearDown(){

        //the report will be created when we call this line
        // if we dont call the flush method it will not be generated
        // we do this at the end of everything
        // finish all your testing, finish all your assertions anf then call this line
        report.flush();
    }
}
