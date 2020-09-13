package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumEasy_Task1 {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: SeleniumEasy Checkbox Verification – Section 1
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //Waiting for charging the page maximum 15 seconds

        //3. Verify “Success – Check box is checked” message is NOT displayed.
        //Locate success message and checkbox under 'single checkbox demo'
        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        //locate the success message
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
        if(!successCheckbox.isDisplayed()){
            System.out.println("Success message is not displayed. Verification PASSED!");
        }else {
            System.out.println("Success message is displayed. Verification FAILED!!!");
        }
        //4. Click to checkbox under “Single Checkbox Demo” section
        successCheckbox.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        if(successCheckbox.isDisplayed()){
            System.out.println("Success message is displayed. Verification PASSED!");
        }else {
            System.out.println("Success message is not displayed. Verification FAILED!!!");
        }

        Thread.sleep(3000);
        driver.close();
    }

}
