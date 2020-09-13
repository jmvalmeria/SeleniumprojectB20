package com.cybertek.softSkills;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment3_Vytrack_TestNG {

    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user174");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        String expectedInTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        Thread.sleep(2000);

        Assert.assertEquals(actualTitle,expectedInTitle, "Title are not the same, Verification FAILED!!!");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
