package com.cybertek.softSkills.Vytrack;

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

public class Assignment4_Vytrack_AC1_V2 {
    /*AC#1 (Jesús)
    (Given) Truck Driver logged in successfully.
    (When) hover mouse pointer over module Fleet and click on Vehicles Odometers in the drop down menu,
    (Then) all the Vehicle information should be displayed on a page called Vehicles Odometer.
    */

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
        WebElement dropdownVehiclesOdometers = driver.findElement(By.linkText("Vehicle Odometer"));
        dropdownVehiclesOdometers.click();

        Thread.sleep(3000);
        //Checking if there is there data in Vehicle Odometer Grid
        List<WebElement> odometerValueList = driver.findElements(By.xpath("//body//td[@data-column-label='Odometer Value']"));

        Assert.assertNotNull(odometerValueList,"No data in Vehicle Odometer Grid, Test FAILED!!!");
    }

}
