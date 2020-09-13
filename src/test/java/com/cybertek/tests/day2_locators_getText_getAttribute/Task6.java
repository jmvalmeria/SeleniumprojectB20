package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {
    /*TC #6: Zero Bankheader verification
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Verify header textExpected: “Log in to ZeroBank”*/


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        System.out.println(driver.findElement(By.tagName("h3")).getText());


        String expectedResult = "Log in to ZeroBank";
        String actualResult = driver.findElement(By.tagName("h3")).getText();

        if (actualResult.equals(expectedResult)){
            System.out.println("Header validation PASSED!");
        } else{
            System.out.println("Header validation FAILED!!!");
        }

    }
}
