package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown_Introduction {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Wait until the page is loaded for the given time
        //It will up to 15 seconds. If page is loaded that it will continue
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. Go to Cybertek - DropDown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_test_1() throws InterruptedException {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //3.Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));
        String actualSelectedOption = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Please select an option";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

        Thread.sleep(2000);
        simpleDropDown.selectByVisibleText("Option 2");
        //4.Verify“State selection” default selected value is correct
        // Expected: “Select a State”
    }

}
