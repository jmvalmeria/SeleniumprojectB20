package com.cybertek.softSkills;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AC14_Automation {
    /*
    AC#14
    Given as authorized truck driver on "Vehicle Costs" page
    When clicking on any line on the grid And I see the General information page
    And by pressing on the "Add Attachments" button at the right top area of the page
    I should be able to add attachments
     */
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //setup webBrowser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize webPage
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go to url https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void login() throws InterruptedException {
        //using truckDriver credentials Login:user164 and password:UserUser123 have to log in and click submit button
        driver.findElement(By.id("prependedInput")).sendKeys("user164");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        //Use Xpath locator find fleetModule and click it
        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetModule.click();
        Thread.sleep(3000);

        //Given as authorized truck driver on "Vehicle Costs" page
        //Use Xpath locator find subModule costVehicle and click it
        WebElement costsVehicle=(driver.findElement(By.xpath("//span[.='Vehicle Costs']")));
        costsVehicle.click();
        Thread.sleep(2000);

        //When clicking on any line on the grid And I see the General information page
        WebElement chooseLine=driver.findElement(By.xpath("//*[@class='string-cell grid-cell grid-body-cell grid-body-cell-Type']"));
        chooseLine.click();
        Thread.sleep(2000);
        //And by pressing on the "Add Attachments" button at the right top area of the page
        WebElement addAttachment=driver.findElement(By.xpath("//a[@title='Add attachment']"));
        addAttachment.click();
        Thread.sleep(2000);
        //upload file
        WebElement upload=driver.findElement(By.name("Choose File"));
        upload.click();
        /*upload.sendKeys("C:/Users/elmiraashimova/Downloads/maxresdefault.jpg");
        Thread.sleep(5000);

        //add comments in comment box
        WebElement addComment=driver.findElement(By.xpath("//textarea[@data-name='field__comment']"));
        addAttachment.findElement(By.xpath("//textarea[@data-name='field__comment']")).sendKeys("I testing attachment board");
        Thread.sleep(5000);

        //click "Save" button
        WebElement submitButton=driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        addAttachment.click();*/
    }

    /*@AfterMethod
    public void closeWindow(){
        driver.close();
    }*/

}
