package com.cybertek.tests.day8_.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CybertekRegistration {
    //TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/registration_form
    // 3.Enter first name
    // 4.Enter last name
    // 5.Enter username
    // 6.Enter email address
    // 7.Enter password
    // 8.Enter phone number
    // 9.Select a gender from radio buttons
    // 10.Enter date of birth
    // 11.Select Department/Office
    // 12.Select Job Title
    // 13.Select programming language from checkboxes
    // 14.Click to sign up button
    // 15.Verify success message “You’ve successfully completed registration.”is displayed.
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");
    }
    @Test
    public void registrationTest() throws InterruptedException {
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().username().replace(".", ""));

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber().replace(".","-").replace("(","").replace(")","").replace(" ","-"));

        WebElement genderCheckbox = driver.findElement(By.xpath("//input[@value='female']"));
        genderCheckbox.click();

        WebElement DOB = driver.findElement(By.xpath("//input[@name='birthday']"));
        DOB.sendKeys(faker.number().numberBetween(1,12) + "/" + faker.number().numberBetween(1,28) + "/" + faker.number().numberBetween(1900,2002));

        Select deptOffice = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        deptOffice.selectByValue("TO");

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        WebElement progLanguage = driver.findElement(By.xpath("//input[@value='java']"));
        progLanguage.click();

        WebElement signupButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signupButton.click();

        Thread.sleep(2000);

        String expectingResult = "You've successfully completed registration!";
        String actualResult = driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(expectingResult,actualResult, "Message is not matching, verification FAILED!!!");

    }

}
