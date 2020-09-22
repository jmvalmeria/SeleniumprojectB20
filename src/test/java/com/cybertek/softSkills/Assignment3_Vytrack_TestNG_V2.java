package com.cybertek.softSkills;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment3_Vytrack_TestNG_V2 {

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1_AC1() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user174");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(3000);

        //DropDown Menu
        WebElement dropdownFleet = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li/a"));
        dropdownFleet.click();
        WebElement dropdownVehiclesOdometers = driver.findElement(By.linkText("Vehicles"));
        dropdownVehiclesOdometers.click();

        Thread.sleep(3000);

        //Checking if there is there data in Vehicle Odometer Grid
        List<WebElement> odometerValueList = driver.findElements(By.xpath("//body//td[@data-column-label='License Plate']"));

        Assert.assertNotNull(odometerValueList,"No data in Vehicle Odometer Grid, Test FAILED!!!");
    }
}
