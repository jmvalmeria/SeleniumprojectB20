package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task3 {
    /*
    TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:
	Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:
	Expected: Google
    */


    public static void main(String[] args) {

        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver(); //This line open the browser
        driver.manage().window().maximize();

        //3- test if driver is working
        driver.get("https://www.google.com");
        driver.findElement(By.linkText("Gmail")).click();

        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

        driver.navigate().back();

        String expectedInTitle1 = "Google";
        String actualTitle1 = driver.getTitle();

        if(actualTitle1.equals(expectedInTitle1)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }

}
