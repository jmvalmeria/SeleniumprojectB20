package com.cybertek.tests.day8_.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tasks7_8 {

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void task7_currentMonth(){
        //TC#7: Cybertek “month” dropdown default value
        //1.Open browser
        //2.Go to website: http://practice.cybertekschool.com/dropdowns
        //3.Verify default value is always showing the current month
        //Expected: If currently in June, should show June selected.

        //This down Statement gets the current month of the year
        Month actualMonth = LocalDate.now().getMonth();

        Select DOB = new Select(driver.findElement(By.id("month")));

        //This down Statement finds the current month of the year other approach
        //String expectingResult = actualMonth.getDisplayName(TextStyle.FULL, new Locale("en","USA"));

        String expectingResult = LocalDateTime.now().getMonth().name().toLowerCase();
        String actualResult = DOB.getFirstSelectedOption().getText().toLowerCase();

        Assert.assertEquals(actualResult,expectingResult, "Month is not matching, verification FAILED!!!");
    }

    @Test
    public void task8_12months(){
        //TC#8: Cybertek “month”dropdown list of default values verification
        //1.Do both verifications in the same test
        //2.Verify list of months are correct as expected.
        //Expected: Options should contain all 12 months of the year.

        ArrayList<String> expectingListOfMonths = new ArrayList<>(Arrays.asList("January","February","March","April","May","June","July","August","September","October","November","December"));
        List<WebElement> actualListOfMonths = driver.findElements(By.xpath("//select[@id='month']/option"));

        ArrayList<String> actualListOfMonthsString = new ArrayList<>();
        for (WebElement each : actualListOfMonths){
            actualListOfMonthsString.add(each.getText());
        }

        Assert.assertEquals(actualListOfMonthsString,expectingListOfMonths, "List are NOT the same, verification FAILED!!!");
    }

}
