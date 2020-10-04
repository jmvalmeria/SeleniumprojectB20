package com.cybertek.softSkills.Bitrix;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AC8_Topic {

    WebDriver driver;
    @BeforeMethod
    /*
        AC#8 - User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
        Given as a HelpDesk, I should be able to login to CRM 24 dashboard
        And I click Message module
        And I click Visual Editor icon
        When I click Topic line,write a message and select employee
        Then I should be able to send text to certain employee
         */
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/stream/");
    }
    @Test
    public void logIn() {
        //This is login with valid credentials
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk14@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser" + Keys.ENTER);

        BrowserUtils.wait(2);

        //It is refresing the web in case that something is left form previous actions
        driver.navigate().refresh();


        //By clicking goes to Message module
        WebElement messageModule = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageModule.click();
        BrowserUtils.wait(2);

        //It finds the Topic Button and clicks on it
        WebElement topicButton = driver.findElement(By.xpath("//span[@title='Topic']"));
        topicButton.click();

        //It finds the Topic Space Title and send a message
        WebElement TopicTitleSpace = driver.findElement(By.xpath("//input[@id='POST_TITLE']"));
        TopicTitleSpace.sendKeys("This message for my group 14");
        BrowserUtils.wait(2);

        //It switch to iframe and type a message
        //1. It finds and switch to the Topic Message Area
        WebElement messageAreaIframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(messageAreaIframe);
        //2. It finds the message Area and send the message
        //I have added JavaFaker so each message can be different and the program do NOT complains
        Faker faker = new Faker();
        WebElement messageArea = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        //messageArea.sendKeys("Believe in yourself! Life is beautiful!!!");
        messageArea.sendKeys("Chuck Norris fact: "+faker.chuckNorris().fact()+ ". Please, Ignore it.");

        //It come back to the parent iframe
        driver.switchTo().parentFrame();
        BrowserUtils.wait(2);

        //By default It will send a message to all employees but if you want o send a message to
        //and specific user you have some logic down this lines

        /*//It select the dropDown menu with the Employee list of contacts
        WebElement addMore = driver.findElement(By.partialLinkText("Add more"));
        addMore.click();
        addMore.sendKeys("helpdesk24@cybertekschool.com" + Keys.ENTER);
        BrowserUtils.wait(2);

        //It finds and clicks on Employees and departments
        WebElement employeesAndDepartmentsLink = driver.findElement(By.partialLinkText("Employees and departments"));
        employeesAndDepartmentsLink.click();
        BrowserUtils.wait(1);

        //It finds select one of the contact for this test "helpdesk24@cybertekschool.com"
        WebElement selectSender = driver.findElement(By.xpath("(//a[@rel='U514'])[2]"));
        selectSender.click();
        BrowserUtils.wait(1);*/

        //Clicks send button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
    }
}
