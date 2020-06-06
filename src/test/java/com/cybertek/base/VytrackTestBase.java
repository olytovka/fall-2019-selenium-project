package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.*;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SoftAssert softAssert;
    protected VehiclesPage vehiclesPage;
    protected CreateCalendarEventsPage createCalendarEventsPage;
    protected CreateContactsPage createContactsPage;

    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpSuite() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }

    @AfterSuite
    public void tearDownSuite() {
        report.flush();
    }

    @Parameters ("url")
    @BeforeMethod
    public void setUpMethod(@Optional  String url){
        System.out.println("url = " + url);
        driver = Driver.getDriver();
        wait =  new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
        if(url == null) {
            driver.get(ConfigurationReader.getProperty("vytrack_url"));
        }else{
            driver.get(url);
        }
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();
        createCalendarEventsPage = new CreateCalendarEventsPage();
        createContactsPage= new CreateContactsPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        // ITestResult gives information about current test: name, status

        //check if the test failed
        //this line will run only for those test cases which have failures
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            //tell extent report that the test failed
            test.fail(iTestResult.getName());

            //take screen shot of the screen and save location
            String screenshot =  BrowserUtils.getScreenshot(iTestResult.getName());
           //show path to screenshot
            test.addScreenCaptureFromPath(screenshot);
        }

        //    Thread.sleep(3000);
        Driver.closeDriver();
        softAssert.assertAll();
    }

}
