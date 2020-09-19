package com.cybertek.tests.day5_testNG_intro_dropdowns.Task;

/*TC#5: Selecting value from non-select dropdown
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Click to non-select dropdown
4.Select Facebook from dropdown
5.Verify title is “Facebook -Log In or Sign Up”*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task5_Facebook {

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void non_select_test1(){
        //3.Click to non-select dropdown
        WebElement dropDownNon_Select = driver.findElement(By.partialLinkText("Dropdown link"));
        dropDownNon_Select.click();

        //4.Select Facebook from dropdown
        WebElement facebookSelect = driver.findElement(By.linkText("Facebook"));
        facebookSelect.click();

        //5.Verify title is “Facebook -Log In or Sign Up”
        String expectingTitle = "Facebook -Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectingTitle, "Title does NOT match, verification FAILED!!!");
    }

}
