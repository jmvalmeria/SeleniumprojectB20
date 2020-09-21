package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    //TC #1: Smartbear software link verification
    //1.Open browser
    //2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3.Enter username: “Tester”
    //4.Enter password: “test”
    //5.Click to Login button
    //6.Print out count of all the links on landing page
    //7.Print out each link text on this page
    //
    //Mini-Task:
    //•Create a method called loginToSmartBear
    //•This method simply logs in to SmartBear when you call it.
    //•Accepts WebDriver type as parameter

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver); //Calls the Login method from SmartBearUtilities
    }

    @Test
    public void task1_login_page_links_print_test(){

        //6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Count of all the links on the page = " + allLinks.size());
        System.out.println("==========================================");

        //7.Print out each link text on this page
        int count = 1;
        for (WebElement eachLink : allLinks){
            System.out.println("link "+count+") " + eachLink.getText());
            count++;
        }

    }

    @Test
    public void task2_create_order_with_javafaker(){
        //6.Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7.Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInput.sendKeys(Keys.BACK_SPACE + "2"); //Delete original value and add 2

        //8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9.Fill address Info with JavaFaker
        //•Generate: name, street, city, state, zip code
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();

        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10.Click on “visa” radio button
        WebElement visaRadio = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadio.click();

        //11.Generate card number using JavaFaker
        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        WebElement expirationInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationInput.sendKeys("12/25");
        //12.Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //13.Verify success message “New order has been successfully added.
        WebElement successMessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successMessage.isDisplayed());
    }


}
