package com.cybertek.tests.day8_Alert_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void p4_iframe_practice(){
        //TC #4 : Iframe practice
        //1. Create a new class called: IframePractice
        //2. Create new test and make set ups
        //3. Go to: http://practice.cybertekschool.com/iframe
        //4. Assert: "Your content goes here." Text is displayed.
        //5. Assert: "An iFrame containing the TinyMCE WYSIWYG Editor

        //3 way of locating
        //1- ByIndex
        //driver.switchTo().frame(0);
        //2- By Id or Name
        //driver.switchTo().frame("mce_0_ifr");
        //3- Locate as a web element, then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is NOT displayed! Verification FAILED!!!");

        //5. Assert: "An iFrame containing the TinyMCE WYSIWYG Editor
        driver.switchTo().defaultContent(); //It move back to the default
        //driver.switchTo().parentFrame(); //It come back to the previous iFrame
        WebElement headerText = driver.findElement(By.xpath("//h3")); //This is pointing to the iframe
        Assert.assertTrue(headerText.isDisplayed(), "Header Text is NOT displayed. Verification FAILED!!!");
    }
}
