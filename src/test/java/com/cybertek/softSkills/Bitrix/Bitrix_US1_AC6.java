package com.cybertek.softSkills.Bitrix;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bitrix_US1_AC6 {
    WebDriver driver;

    @BeforeMethod
    public void  setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void test_Us1_AC6(){
        /*(Given) Help Desk user located at Active Stream
        and click on “Add comment” box
        (When) Click on the “Add mention” icon, select an exployee/s or departament, write a text and click on “SEND” Button.
        (Then) User should be able to send a mention in the Activity Stream chat.
        */

        //This is the login part with the credentials
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk24@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser" + Keys.ENTER);

        BrowserUtils.wait(2);

        //It looks for the Add comment box
        WebElement addComment = driver.findElement(By.linkText("Add comment"));
        addComment.click();

        //It looks for Add mention Icon
        WebElement addMention = driver.findElement(By.xpath("//span[@title='Add mention'][1]"));
        addMention.click();

        BrowserUtils.wait(2);

        //It select the dropDown menu with the Employee list of contacts
        WebElement destDepartmentTab = driver.findElement(By.partialLinkText("Employees and departments"));
        destDepartmentTab.click();

        BrowserUtils.wait(2);
        //It select one of the contact for this test "helpdesk25@cybertekschool.com"
        WebElement selectEmail = driver.findElement(By.xpath("(//a[@rel='U515'])[2]"));
        selectEmail.click();

        //It gets access to the iframe
        WebElement iframeMention = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframeMention);

        //It types a message in the iframe message area
        WebElement mentionText = driver.findElement(By.xpath("//span[@class='bxhtmled-metion']"));
        mentionText.sendKeys("Ignore this message, it is a TEST");

        //It switch back to the parent Frame
        driver.switchTo().parentFrame();

        BrowserUtils.wait(2);
        //It clicks the send button
        WebElement sendButton = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-sm ui-btn-primary']"));
        sendButton.click();

        //It is the verification Test
        WebElement messageDiplayed = driver.findElement(By.xpath("//div[@class='feed-com-text-inner-inner']"));
        Assert.assertTrue(messageDiplayed.isDisplayed(), "Message is NOT displayed, verification FAILED!!!");

    }
}
