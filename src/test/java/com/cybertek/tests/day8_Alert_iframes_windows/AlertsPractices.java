package com.cybertek.tests.day8_Alert_iframes_windows;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void p1_information_alert_practice(){
        //TC #1: Information alert practice
        //1.Open browser
        //2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        //3.Click to “Click for JS Alert”button
        //4.Click to OK button from the alert
        //5.Verify “You successfulyclicked an alert”text is displayed.

        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        warningAlertButton.click();

        //1. Create Alert instance and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        //2. Use "alert" instance to accept the javascript alert(popup)
        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED!!!");

    }

    @Test
    public void p2_confirmation_alert_practice(){
        //TC #2: Confirmationalert practice
        //1.Open browser
        //2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        //3.Click to “Click for JS Confirm” button
        //4.Click to OK button from the alert
        //5.Verify “You clicked: Ok” text is displayed.

        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        warningAlertButton.click();

        //1.- Create the Alert Instance
        Alert alert = driver.switchTo().alert();
        //2.- Then click Ok, We can accept() or dismiss() the confirmation alert
        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        BrowserUtils.wait(2);

        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED!!!");

    }

    @Test
    public void p3_confirmation_alert_practice(){
        //TC #3: Information alert practice
        //1.Open browser
        //2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        //3.Click to “Click for JS Prompt” button
        //4.Send “hello”text to alert
        //5.Click to OK button from the alert
        //6.Verify “You entered:  hello” text is displayed.

        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        warningAlertButton.click();

        //1.- Create the Alert Instance
        Alert alert = driver.switchTo().alert();
        //2.- Then click Ok, We can accept() or dismiss() the confirmation alert
        alert.sendKeys("Hello");

        BrowserUtils.wait(3);

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        BrowserUtils.wait(2);

        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED!!!");

    }
}
