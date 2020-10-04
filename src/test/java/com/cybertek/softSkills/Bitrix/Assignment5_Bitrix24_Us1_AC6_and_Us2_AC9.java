package com.cybertek.softSkills.Bitrix;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment5_Bitrix24_Us1_AC6_and_Us2_AC9 {
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

    @Test
    public void test_Us2_AC9(){
        /*(Given) Help Desk user located at My Tasks
        and click on the “NEW TASKS” button and type the task in the “Things to do” box.
        (When) click on the “Deadline” box and select the day in the date picker and click on the “ADD TASK (CTRL + ENTER)” button
        (Then) User should be able to see the new task in the task grid with the assigned day under the column DEADLINE.
        */

        //This is the login part with the credentials
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk24@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser" + Keys.ENTER);

        BrowserUtils.wait(2);

        //It goes to Task module
        WebElement taskLink = driver.findElement(By.partialLinkText("Tasks"));
        taskLink.click();

        //It clicks on The New Task Button
        WebElement newtaskButton = driver.findElement(By.id("tasks-buttonAdd"));
        newtaskButton.click();

        BrowserUtils.wait(2);

        //It switch to the task iframe
        WebElement thingsToDoFrame = driver.findElement(By.xpath("//iframe[@class='side-panel-iframe']"));
        driver.switchTo().frame(thingsToDoFrame);

        //It types the task in the title of the task
        WebElement thingsToDoSpace = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        thingsToDoSpace.sendKeys("Ignored it, This is a New Task TEST");

        //It clicks on Deadline Picker
        WebElement dataPicker = driver.findElement(By.xpath("//input[@data-bx-id='datepicker-display']"));
        dataPicker.click();

        BrowserUtils.wait(1);

        //It selects the day
        WebElement daySelection = driver.findElement(By.partialLinkText("10"));
        daySelection.click();

        BrowserUtils.wait(1);

        //It clicks on the <select> button
        WebElement selectButton = driver.findElement(By.partialLinkText("Select"));
        selectButton.click();

        //It clicks on the <Add Task> button
        WebElement addTaskButton = driver.findElement(By.xpath("//button[@data-bx-id='task-edit-submit']"));
        addTaskButton.click();

        //It switch to the default iframe
        driver.switchTo().defaultContent();

        BrowserUtils.wait(1);

        //It is the verification Test
        WebElement taskDisplay = driver.findElement(By.partialLinkText("Ignored it, This is a New Task TEST"));
        Assert.assertTrue(taskDisplay.isDisplayed(),"Message is NOT displayed, verification FAILED!!!");

    }

   @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}