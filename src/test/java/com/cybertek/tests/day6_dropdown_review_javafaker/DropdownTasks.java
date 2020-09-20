package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        //TC#2: Selecting state from State dropdown and verifyingresult
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(1000);
        stateDropDown.selectByVisibleText("Illinois");
        //3.Select Illinois4.Select Virginia
        Thread.sleep(1000);
        stateDropDown.selectByValue("VA");
        //5.Select California
        Thread.sleep(1000);
        stateDropDown.selectByIndex(5);
        //6.Verify final selected option is California.
        String expectedResult = "California";
        String actualResult = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult, "Actual vs expected is NOT equal!");
        //Use all Select options.(visible text, value, index)
    }

}
