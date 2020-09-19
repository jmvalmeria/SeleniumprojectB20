package com.cybertek.tests.day5_testNG_intro_dropdowns.Task;

/*TC#4: Selecting value from multiple select dropdown
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select all the options from multiple select dropdown.
4.Print out all selected values.
5.Deselect all values.*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_Multiple_selection {

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void dropDown_Test1() throws InterruptedException {
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //3.Select all the options from multiple select dropdown.
        Select selectSimpleDropDown = new Select(driver.findElement(By.id("dropdown")));
        selectSimpleDropDown.selectByVisibleText("Option 1");

        Select selectDoBYear = new Select(driver.findElement(By.id("year")));
        selectDoBYear.selectByVisibleText("1979");
        Select selectDoBMonth = new Select(driver.findElement(By.id("month")));
        selectDoBMonth.selectByVisibleText("January");
        Select selectDoBDay = new Select(driver.findElement(By.id("day")));
        selectDoBDay.selectByVisibleText("31");

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByValue("PA");

        Select selectPLanguage = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        selectPLanguage.selectByVisibleText("Java");

        WebElement DropDownSelectWebsite = driver.findElement(By.partialLinkText("Dropdown link"));
        DropDownSelectWebsite.click();

        //4.Print out all selected values.
        System.out.println("Simple dropdown selection: " + selectSimpleDropDown.getFirstSelectedOption().getText());
        System.out.println("Select your date of birth selection: Year-" + selectDoBYear.getFirstSelectedOption().getText() +" Month-"+ selectDoBMonth.getFirstSelectedOption().getText() + " Day- " + selectDoBDay.getFirstSelectedOption().getText());
        System.out.println("State selection: " + selectState.getFirstSelectedOption().getText());
        System.out.println("Which programming languages do you know? " + selectPLanguage.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        //5.Deselect all values.
        selectSimpleDropDown.selectByIndex(0);
        selectDoBYear.selectByIndex(0);
        selectDoBMonth.selectByIndex(0);
        selectDoBDay.selectByIndex(0);
        selectState.selectByIndex(0);
        selectPLanguage.selectByIndex(0);
        DropDownSelectWebsite.click();

        driver.navigate().refresh();

    }


}
