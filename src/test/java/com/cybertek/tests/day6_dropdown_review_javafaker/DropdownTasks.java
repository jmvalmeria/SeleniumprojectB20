package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
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

    @Test
    public void Test3_date_dropdown_verification(){
        //TC#3: Selecting date on dropdown and verifying
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
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

    @Test
    public void test4_multiple_value_select_dropdown() throws InterruptedException {
        //TC#4: Selecting value from multiple select dropdown
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        //3.Select all the options from multiple select dropdown.
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        for (WebElement each : allOptions) {
            Thread.sleep(500);
            each.click();

            //4.Print out all selected values.
            System.out.println("Selected: " + each.getText());
            Assert.assertTrue(each.isSelected(), "The option: "+each.getText()+" is not selected");

            //5.Deselect all values.
            multipleSelectDropdown.deselectAll();
        }
        for (WebElement each : allOptions){
            Assert.assertFalse(each.isSelected());
        }
    }

    @Test
    public void test5_html_dropdown_handling(){
        //C#5: Selecting value from non-select dropdown
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown

        //3.Click to non-select dropdown
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));
        websiteDropdown.click();
        //4.Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookLink.click();
        //5.Verify title is “Facebook -Log In or Sign Up”
        String expectedTitle = "Facebook -Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle,"Title does NOT match, verification FAILED!!!");

    }

}
