package com.cybertek.tests.day5_testNG_intro_dropdowns.Task;

/*TC#3: Selecting date on dropdown and verifying
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select “December 1st, 1921” and verify it is selected.
Select year using: visible text
Select month using : value attribute
Select day using: index number*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task3_December_1_1921 {

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        //TC#3: Selecting date on dropdown and verifying
        //1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void dropDown_test1() {
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //3.Select “December 1st, 1921” and verify it is selected.
        Select dropDownYear = new Select(driver.findElement(By.id("year")));
        Select dropDownMonth = new Select(driver.findElement(By.id("month")));
        Select dropDownDay = new Select(driver.findElement(By.id("day")));
        //Select year using: visible text
        dropDownYear.selectByVisibleText("1921");
        //Select month using : value attribute
        dropDownMonth.selectByValue("11");
        //Select day using: index number
        dropDownDay.selectByIndex(0);

        String actualSelectedOptionYear = dropDownYear.getFirstSelectedOption().getText();
        String expectedSelectedOptionYear = "1921";

        String actualSelectedOptionMonth = dropDownMonth.getFirstSelectedOption().getText();
        String expectedSelectedOptionMonth = "December";

        String actualSelectedOptionDay = dropDownDay.getFirstSelectedOption().getText();
        String expectedSelectedOptionDay = "1";

        Assert.assertEquals(actualSelectedOptionYear,expectedSelectedOptionYear, "Year is Not matching!!!");
        Assert.assertEquals(actualSelectedOptionMonth,expectedSelectedOptionMonth, "Month is NOT matching!!!");
        Assert.assertEquals(actualSelectedOptionDay,expectedSelectedOptionDay, "Day is NOT matching!!!");

    }

}
